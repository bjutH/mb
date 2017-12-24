package com.bjut.MB.Utils;

import com.bjut.MB.dao.*;
import com.bjut.MB.model.*;
import com.bjut.MB.model.Header;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * Created by Administrator on 2017/11/14.
 */
@Service
public class ExcelUtils {
    private static final Logger logger = LoggerFactory.getLogger(ExcelUtils.class);
    private org.apache.poi.ss.usermodel.Sheet sheet;
    private Workbook wb;

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private YiqiDao yiqiDao;
    @Autowired
    private RemadeDao remadeDao;
    @Autowired
    private AgingDao agingDao;
    @Autowired
    private PackDao packDao;
    @Autowired
    private DebugDao debugDao;
    @Autowired
    private ProcessTestDao processTestDao;
    @Autowired
    private MachineTestDao machineTestDao;
    @Autowired
    private ProductTestDao productTestDao;
    @Autowired
    private SphygmomanometerDao sphygmomanometerDao;
    @Autowired
    private PerformTestDao performTestDao;
    @Autowired
    private FinalTestDao finalTestDao;
    @Autowired
    private HeaderDao headerDao;

    /**
     *
     * @param modelPath EXCEL文件路径
     * @param number     随工单编号
     * @param type       哪张表单
     */
    //public void importExcel(String modelPath, int x, int y,String number, String type){
    public void importExcel(String modelPath, String number, String type){
        Map<String, String> map = new HashMap<String, String>();
        File file = new File(modelPath);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            if(!file.exists()){
                out.println("模板文件:"+modelPath+"不存在!");
            }
            wb=new XSSFWorkbook(fis);
            sheet = wb.getSheet("Sheet1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String id = number;
        String process = null;
        String value = null;
        int rowNum = sheet.getLastRowNum();
        for (int i = 0; i <= rowNum; i++) {
            Row row = sheet.getRow(i);
            // 获取行里面的总列数
            int columnNum = 0;
            if(row!=null){
                columnNum = row.getPhysicalNumberOfCells();
            }
            for (int j = 0; j < columnNum; j++) {
                XSSFCell cell = (XSSFCell) sheet.getRow(i).getCell(j);
                cell.setCellType(Cell.CELL_TYPE_STRING);
                String cellValue = cell.getStringCellValue();
//                if(i==x &&j==y){
//                    id = cellValue;
//                }
                if(cellValue.contains("*")){
                    process = cellValue.substring(1, cellValue.length());
                    switch (process){
                        case "number":
                            value = number;
                            setCellStrValue(i, j, value);
//                        case "lable":
//                            value = number;
//                            setCellStrValue(i, j, value);
                    }
                }
                if(cellValue.contains("$")){
                    process = cellValue.substring(1, cellValue.length());
                    switch (type){
                        case "随工单":
                            orderDao.addItem(id, process, modelPath);
                            break;
                        case  "仪器备忘录":
                            yiqiDao.addItem(id, process, modelPath);
                            break;
                        case "老化观测表":
                            agingDao.addItem(id, process, modelPath);
                            break;
                        case "装箱记录单":
                            packDao.addItem(id, process, modelPath);
                            break;
                        case "整机调试报告单":
                            debugDao.addItem(id, process, modelPath);
                            break;
                        case "工序检验报告单":
                            processTestDao.addItem(id, process, modelPath);
                            break;
                        case "整机检验报告单":
                            machineTestDao.addItem(id, process, modelPath);
                            break;
                        case "成品检验报告单":
                            productTestDao.addItem(id, process, modelPath);
                            break;
                        case "血压计检定报告单":
                            sphygmomanometerDao.addItem(id, process, modelPath);
                            break;
                        case "性能要求检验单":
                            performTestDao.addItem(id, process, modelPath);
                            break;
                        case "最终检验报告单":
                            finalTestDao.addItem(id, process, modelPath);
                            break;
                    }
                }
            }
        }
        try {
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {
            wb.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 替换随工单内容读写操作
     * @param modelPath 随工单路径
     * @param type      随工单类型
     * @param Process   随工单工序内容
     * @param object    随工单具体对象
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里
     */
    public Map<String,String> replaceExcel(String modelPath, String type, String Process, Object object){
//    	String[] arr = modelPath.split("\\.");
//    	String copyPath = "";
//    	for(int i=0;i<arr.length -1;i++){
//    		copyPath += arr[i];
//    	}
//    	//long time = System.currentTimeMillis();
//    	copyPath +="-1."  + arr[arr.length -1];
//    	try {
//			copyFile(new File(modelPath), new File(copyPath));
//		} catch (IOException e2) {
//			e2.printStackTrace();
//		}
        Map<String,String> map = new HashMap<>();
        File file = new File(modelPath);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (Exception e1) {
            e1.printStackTrace();
            map.put("code","2");
            map.put("msg","文件无法读取！");
            return map;
        }
        try {
            if(!file.exists()){
                map.put("code","2");
                map.put("msg","文件不存在！");
                return map;
            }
            wb=new XSSFWorkbook(fis);
            sheet = wb.getSheet("Sheet1");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","2");
            map.put("msg","文件不存在！");
            return map;
        }
        replaceDate(type, Process, object);
        try {
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","2");
            map.put("msg","文件无法关闭！");
            return map;
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (Exception e1) {
            e1.printStackTrace();
            map.put("code","2");
            map.put("msg","文件无法写入！");
            return map;
        }
        try {
            wb.write(fos);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","2");
            map.put("msg","文件无法写入！");
            return map;
        }
        map.put("code","1");
        return map;
    }

    /**
     * 替换EXCEL内容
     * @param type      随工单表格类型
     * @param process   随工单工序内容
     * @param object    随工单具体对象
     */
    private void replaceDate(String type, String process, Object object){
        // 获取行数
        String id = null;
        int rowNum = sheet.getLastRowNum();
        for (int i = 0; i <= rowNum; i++) {
            Row	row = sheet.getRow(i);
            // 获取行里面的总列数
            int columnNum = 0;
            if(row!=null){
                columnNum = row.getPhysicalNumberOfCells();
            }
            for (int j = 0; j < columnNum; j++) {
                XSSFCell cell = (XSSFCell) sheet.getRow(i).getCell(j);
                String cellValue = cell.getStringCellValue();
                if(!StringUtils.isBlank(cellValue)){
                    String first = String.valueOf(cellValue.charAt(0));
                    if(first.equals("*")){
                        String value = null;
                        String string = cellValue.substring(1, cellValue.length());
                        switch (type){
                            case "随工单":
                                switch (string){
                                    case "型号":
                                        value=((Header) object).getProductType();
                                        break;
                                    case "内部标记":
                                        value=((Header) object).getInnerLabel();
                                        break;
                                    case "名称":
                                        value=((Header) object).getProductName();
                                        break;
                                }
                                break;
                            case "整机调试报告单":
                                switch (string) {
                                    case "内部标记":
                                        value = ((Header) object).getInnerLabel();
                                        break;
                                    case "仪器型号":
                                        value = ((Header) object).getProductType();
                                        break;
                                    case "调试结论":
                                        value = ((Header) object).getDebugConclusion();
                                        break;
                                    case "调试人员":
                                        value = "";
                                        String GifPath = ((Header) object).getDebuger();
                                        setCellStrGif(i,j,GifPath);
                                        break;
                                    case "调试日期":
                                        value = ((Header) object).getDebugDate().toString();
                                        break;
                                    case "环境温度":
                                        value = ((Header) object).getEnvironmentTemperature();
                                        break;
                                    case "相对湿度":
                                        value = ((Header) object).getRelativeHumidity();
                                        break;
                                    case "供电电源":
                                        value = ((Header) object).getPower();
                                        break;
                                    case "有效接地":
                                        value = ((Header) object).getIsGroud();
                                        break;
                                }
                                break;
                            case "工序检验报告单":
                                switch (string) {
                                    case "内部标记":
                                        value = ((Header) object).getInnerLabel();
                                        break;
                                    case "仪器型号":
                                        value = ((Header) object).getProductType();
                                        break;
                                    case "检验结论":
                                        value = ((Header) object).getDebugConclusion();
                                        break;
                                    case "检验人员":
                                        value = "";
                                        String GifPath = ((Header) object).getDebuger();
                                        setCellStrGif(i,j,GifPath);
                                        break;
                                    case "检验日期":
                                        value = ((Header) object).getDebugDate().toString();
                                        break;
                                    case "环境温度":
                                        value = ((Header) object).getEnvironmentTemperature();
                                        break;
                                    case "相对湿度":
                                        value = ((Header) object).getRelativeHumidity();
                                        break;
                                    case "供电电源":
                                        value = ((Header) object).getPower();
                                        break;
                                    case "有效接地":
                                        value = ((Header) object).getIsGroud();
                                        break;
                                }
                                break;
                            case "整机检验报告单":
                                switch (string) {
                                    case "内部标记":
                                        value = ((Header) object).getInnerLabel();
                                        break;
                                    case "仪器型号":
                                        value = ((Header) object).getProductType();
                                        break;
                                    case "检验结论":
                                        value = ((Header) object).getDebugConclusion();
                                        break;
                                    case "检验人员":
                                        value = "";
                                        String GifPath = ((Header) object).getDebuger();
                                        setCellStrGif(i,j,GifPath);
                                        break;
                                    case "检验日期":
                                        value = ((Header) object).getDebugDate().toString();
                                        break;
                                    case "环境温度":
                                        value = ((Header) object).getEnvironmentTemperature();
                                        break;
                                    case "相对湿度":
                                        value = ((Header) object).getRelativeHumidity();
                                        break;
                                    case "供电电源":
                                        value = ((Header) object).getPower();
                                        break;
                                    case "有效接地":
                                        value = ((Header) object).getIsGroud();
                                        break;
                                    case "检测设备名称1":
                                        value = ((Header) object).getCheckMachineName1();
                                        break;
                                    case "检测设备型号1":
                                        value = ((Header) object).getCheckMachineType1();
                                        break;
                                    case "检测设备编号1":
                                        value = ((Header) object).getCheckMachineNum1();
                                        break;
                                    case "检测设备名称2":
                                        value = ((Header) object).getCheckMachineName2();
                                        break;
                                    case "检测设备型号2":
                                        value = ((Header) object).getCheckMachineType2();;
                                        break;
                                    case "检测设备编号2":
                                        value = ((Header) object).getCheckMachineNum2();
                                        break;
                                    case "检测设备名称3":
                                        value = ((Header) object).getCheckMachineName3();
                                        break;
                                    case "检测设备型号3":
                                        value = ((Header) object).getCheckMachineType3();
                                        break;
                                    case "检测设备编号3":
                                        value = ((Header) object).getCheckMachineNum3();
                                        break;
                                    case "检测设备名称4":
                                        value = ((Header) object).getCheckMachineName4();
                                        break;
                                    case "检测设备型号4":
                                        value = ((Header) object).getCheckMachineType4();
                                        break;
                                    case "检测设备编号4":
                                        value = ((Header) object).getCheckMachineNum4();
                                        break;
                                }
                                break;
                            case "成品检验报告单":
                                switch (string) {
                                    case "型号":
                                        value = ((Header) object).getProductType();
                                        break;
                                    case "检验员":
                                        value = "";
                                        String GifPath = ((Header) object).getDebuger();
                                        setCellStrGif(i,j,GifPath);
                                        break;
                                    case "复核员":
                                        value = "";
                                        String GifPath1 = ((Header) object).getChecker();
                                        setCellStrGif(i,j,GifPath1);
                                        break;
                                    case "检验结论":
                                        value = ((Header) object).getDebugConclusion();
                                        break;
                                    case "检验日期":
                                        value = ((Header) object).getDebugDate().toString();
                                        break;
                                    case "环境温度":
                                        value = ((Header) object).getEnvironmentTemperature();
                                        break;
                                    case "相对湿度":
                                        value = ((Header) object).getRelativeHumidity();
                                        break;
                                    case "供电电源":
                                        value = ((Header) object).getPower();
                                        break;
                                    case "有效接地":
                                        value = ((Header) object).getIsGroud();
                                        break;
                                    case "检测设备名称1":
                                        value = ((Header) object).getCheckMachineName1();
                                        break;
                                    case "检测设备型号1":
                                        value = ((Header) object).getCheckMachineType1();
                                        break;
                                    case "检测设备编号1":
                                        value = ((Header) object).getCheckMachineNum1();
                                        break;
                                    case "检测设备名称2":
                                        value = ((Header) object).getCheckMachineName2();
                                        break;
                                    case "检测设备型号2":
                                        value = ((Header) object).getCheckMachineType2();;
                                        break;
                                    case "检测设备编号2":
                                        value = ((Header) object).getCheckMachineNum2();
                                        break;
                                    case "检测设备名称3":
                                        value = ((Header) object).getCheckMachineName3();
                                        break;
                                    case "检测设备型号3":
                                        value = ((Header) object).getCheckMachineType3();
                                        break;
                                    case "检测设备编号3":
                                        value = ((Header) object).getCheckMachineNum3();
                                        break;
                                    case "检测设备名称4":
                                        value = ((Header) object).getCheckMachineName4();
                                        break;
                                    case "检测设备型号4":
                                        value = ((Header) object).getCheckMachineType4();
                                        break;
                                    case "检测设备编号4":
                                        value = ((Header) object).getCheckMachineNum4();
                                        break;
                                    case "检测设备名称5":
                                        value = ((Header) object).getCheckMachineName5();
                                        break;
                                    case "检测设备型号5":
                                        value = ((Header) object).getCheckMachineType5();
                                        break;
                                    case "检测设备编号5":
                                        value = ((Header) object).getCheckMachineNum5();
                                        break;
                                    case "检测设备名称6":
                                        value = ((Header) object).getCheckMachineName6();
                                        break;
                                    case "检测设备型号6":
                                        value = ((Header) object).getCheckMachineType6();;
                                        break;
                                    case "检测设备编号6":
                                        value = ((Header) object).getCheckMachineNum6();
                                        break;
                                    case "检测设备名称7":
                                        value = ((Header) object).getCheckMachineName7();
                                        break;
                                    case "检测设备型号7":
                                        value = ((Header) object).getCheckMachineType7();
                                        break;
                                    case "检测设备编号7":
                                        value = ((Header) object).getCheckMachineNum7();
                                        break;
                                    case "检测设备名称8":
                                        value = ((Header) object).getCheckMachineName8();
                                        break;
                                    case "检测设备型号8":
                                        value = ((Header) object).getCheckMachineType8();
                                        break;
                                    case "检测设备编号8":
                                        value = ((Header) object).getCheckMachineNum8();
                                        break;
                                    case "检测设备名称9":
                                        value = ((Header) object).getCheckMachineName9();
                                        break;
                                    case "检测设备型号9":
                                        value = ((Header) object).getCheckMachineType9();
                                        break;
                                    case "检测设备编号9":
                                        value = ((Header) object).getCheckMachineNum9();
                                        break;
                                    case "检测设备名称10":
                                        value = ((Header) object).getCheckMachineName10();
                                        break;
                                    case "检测设备型号10":
                                        value = ((Header) object).getCheckMachineType10();;
                                        break;
                                    case "检测设备编号10":
                                        value = ((Header) object).getCheckMachineNum10();
                                        break;
                                    case "检测设备名称11":
                                        value = ((Header) object).getCheckMachineName11();
                                        break;
                                    case "检测设备型号11":
                                        value = ((Header) object).getCheckMachineType11();
                                        break;
                                    case "检测设备编号11":
                                        value = ((Header) object).getCheckMachineNum11();
                                        break;
                                    case "检测设备名称12":
                                        value = ((Header) object).getCheckMachineName12();
                                        break;
                                    case "检测设备型号12":
                                        value = ((Header) object).getCheckMachineType12();
                                        break;
                                    case "检测设备编号12":
                                        value = ((Header) object).getCheckMachineNum12();
                                        break;
                                }
                                break;
                            case "血压计检定报告单":
                                switch (string) {
                                    case "机型":
                                        value = ((Header) object).getProductType();
                                        break;
                                    case "环境温度":
                                        value = ((Header) object).getEnvironmentTemperature();
                                        break;
                                    case "相对湿度":
                                        value = ((Header) object).getRelativeHumidity();
                                        break;
                                    case "供电电源":
                                        value = ((Header) object).getPower();
                                        break;
                                    case "有效接地":
                                        value = ((Header) object).getIsGroud();
                                        break;
                                    case "检测设备名称1":
                                        value = ((Header) object).getCheckMachineName1();
                                        break;
                                    case "检测设备型号1":
                                        value = ((Header) object).getCheckMachineType1();
                                        break;
                                    case "检测设备编号1":
                                        value = ((Header) object).getCheckMachineNum1();
                                        break;
                                    case "检测设备名称2":
                                        value = ((Header) object).getCheckMachineName2();
                                        break;
                                    case "检测设备型号2":
                                        value = ((Header) object).getCheckMachineType2();;
                                        break;
                                    case "检测设备编号2":
                                        value = ((Header) object).getCheckMachineNum2();
                                        break;
                                    case "检测设备名称3":
                                        value = ((Header) object).getCheckMachineName3();
                                        break;
                                    case "检测设备型号3":
                                        value = ((Header) object).getCheckMachineType3();
                                        break;
                                    case "检测设备编号3":
                                        value = ((Header) object).getCheckMachineNum3();
                                        break;
                                    case "检测设备名称4":
                                        value = ((Header) object).getCheckMachineName4();
                                        break;
                                    case "检测设备型号4":
                                        value = ((Header) object).getCheckMachineType4();
                                        break;
                                    case "检测设备编号4":
                                        value = ((Header) object).getCheckMachineNum4();
                                        break;
                                    case "检验人":
                                        value = "";
                                        String GifPath = ((Header) object).getDebuger();
                                        setCellStrGif(i,j,GifPath);
                                        break;
                                    case "核验人":
                                        value = "";
                                        String GifPath1 = ((Header) object).getChecker();
                                        setCellStrGif(i,j,GifPath1);
                                        break;
                                    case "批准人":
                                        value = "";
                                        String GifPath2 = ((Header) object).getChecker2();
                                        setCellStrGif(i,j,GifPath2);
                                        break;
                                    case "检验日期":
                                        value = ((Header) object).getDebugDate().toString();
                                        break;
                                    case "核验日期":
                                        value = ((Header) object).getCheckDate().toString();
                                        break;
                                    case "批准日期":
                                        value = ((Header) object).getCheckDate2().toString();
                                        break;
                                    case "检验结论":
                                        value = ((Header) object).getDebugConclusion();
                                        break;
                                }
                                break;
                            case "性能要求检验单":
                                switch (string) {
                                    case "机型":
                                        value = ((Header) object).getProductType();
                                        break;
                                    case "环境温度":
                                        value = ((Header) object).getEnvironmentTemperature();
                                        break;
                                    case "相对湿度":
                                        value = ((Header) object).getRelativeHumidity();
                                        break;
                                    case "供电电源":
                                        value = ((Header) object).getPower();
                                        break;
                                    case "有效接地":
                                        value = ((Header) object).getIsGroud();
                                        break;
                                    case "检测设备名称1":
                                        value = ((Header) object).getCheckMachineName1();
                                        break;
                                    case "检测设备型号1":
                                        value = ((Header) object).getCheckMachineType1();
                                        break;
                                    case "检测设备编号1":
                                        value = ((Header) object).getCheckMachineNum1();
                                        break;
                                    case "检测设备名称2":
                                        value = ((Header) object).getCheckMachineName2();
                                        break;
                                    case "检测设备型号2":
                                        value = ((Header) object).getCheckMachineType2();;
                                        break;
                                    case "检测设备编号2":
                                        value = ((Header) object).getCheckMachineNum2();
                                        break;
                                    case "检测设备名称3":
                                        value = ((Header) object).getCheckMachineName3();
                                        break;
                                    case "检测设备型号3":
                                        value = ((Header) object).getCheckMachineType3();
                                        break;
                                    case "检测设备编号3":
                                        value = ((Header) object).getCheckMachineNum3();
                                        break;
                                    case "检验人":
                                        value = "";
                                        String GifPath = ((Header) object).getDebuger();
                                        setCellStrGif(i,j,GifPath);
                                        break;
                                    case "核验人":
                                        value = "";
                                        String GifPath1 = ((Header) object).getChecker();
                                        setCellStrGif(i,j,GifPath1);
                                        break;
                                    case "批准人":
                                        value = "";
                                        String GifPath2 = ((Header) object).getChecker2();
                                        setCellStrGif(i,j,GifPath2);
                                        break;
                                    case "检验日期":
                                        value = ((Header) object).getDebugDate().toString();
                                        break;
                                    case "核验日期":
                                        value = ((Header) object).getCheckDate().toString();
                                        break;
                                    case "批准日期":
                                        value = ((Header) object).getCheckDate2().toString();
                                        break;
                                    case "检验结论":
                                        value = ((Header) object).getDebugConclusion();
                                        break;
                                }
                                break;
                            case "最终检验报告单":
                                switch (string) {
                                    case "仪器型号":
                                        value = ((Header) object).getProductType();
                                        break;
                                    case "内部标记":
                                        value = ((Header) object).getInnerLabel();
                                        break;
                                    case "检验结果":
                                        value = ((Header) object).getDebugConclusion();
                                        break;
                                    case "检 验 员":
                                        value = "";
                                        String GifPath = ((Header) object).getDebuger();
                                        setCellStrGif(i,j,GifPath);
                                        break;
                                    case "检验日期":
                                        value = ((Header) object).getDebugDate().toString();
                                        break;
                                    case "核验/放行人":
                                        value = "";
                                        String GifPath1 = ((Header) object).getCheckMachineName1();
                                        setCellStrGif(i,j,GifPath1);
                                        break;
                                    case "核验/放行日期":
                                        value = ((Header) object).getCheckDate().toString();
                                        break;
                                }
                                break;
                        }
                        setCellStrValue(i, j, value);
                    }
                    if(first.equals("#")) {
                        String last = String.valueOf(cellValue.charAt(cellValue.length() - 1));
                        String value = null;
                        String string = cellValue.substring(1, cellValue.length() - 1);
                        if (string.equals(process)) {
                            switch (type) {
                                case "随工单":
                                    switch (last) {
                                        case "1":
                                            value = "";
                                            String GifPath = ((Order) object).getOperater();
                                            setCellStrGif(i,j,GifPath);
                                            break;
                                        case "2":
                                            value = ((Order) object).getOther();
                                            break;
                                        case "3":
                                            value = ((Order) object).getPs();
                                            break;
                                    }
                                    break;
                                case "仪器备忘录":
                                    switch (last) {
                                        case "1":
                                            value = ((Memo) object).getNumber();
                                            break;
                                        case "2":
                                            value = ((Memo) object).getBoardNum();
                                            break;
                                        case "3":
                                            value = ((Memo) object).getWeld();
                                            break;
                                        case "4":
                                            value = ((Memo) object).getDebug();
                                            break;
                                        case "5":
                                            value = ((Memo) object).getTest();
                                            break;
                                        case "6":
                                            value = ((Memo) object).getVersion();
                                            break;
                                        case "7":
                                            value = ((Memo) object).getPs();
                                            break;
                                    }
                                    break;
                                case "老化观测表":
                                    switch (last) {
                                        case "1":
                                            value = "";
                                            String GifPath = ((Aging) object).getDebuger();
                                            setCellStrGif(i,j,GifPath);
                                            break;
                                        case "2":
                                            value = ((Aging) object).getDate().toString();
                                            break;
                                        case "3":
                                            value = ((Aging) object).getPhenomenon();
                                            break;
                                        case "4":
                                            value = ((Aging) object).getHandle();
                                            break;
                                        case "5":
                                            value = ((Aging) object).getPs();
                                            break;
                                        case "6":
                                            value = ((Aging) object).getDebuger();
                                            break;
                                    }
                                    break;
                                case "装箱记录单":
                                    switch (last) {
                                        case "1":
                                            value = "";
                                            String GifPath = ((Pack) object).getPackager();
                                            setCellStrGif(i,j,GifPath);
                                            break;
                                        case "2":
                                            value = ((Pack) object).getCheck();
                                            break;
                                        case "3":
                                            value = ((Pack) object).getPackager();
                                            break;
                                    }
                                    break;
                                case "整机调试报告单":
                                    switch (last) {
                                        case "1":
                                            value = ((Debug) object).getData();
                                            break;
                                        case "2":
                                            value = ((Debug) object).getResult();
                                            break;
                                        case "3":
                                            value = ((Debug) object).getDetectionDevice();
                                            break;
                                        case "4":
                                            value = ((Debug) object).getDeviceType();
                                            break;
                                        case "5":
                                            value = ((Debug) object).getDeviceNum();
                                            break;
                                        case "6":
                                            value = ((Debug) object).getPs();
                                            break;
                                    }
                                    break;
                                case "工序检验报告单":
                                    switch (last) {
                                        case "1":
                                            value = ((ProcessTest) object).getData();
                                            break;
                                        case "2":
                                            value = ((ProcessTest) object).getResult();
                                            break;
                                        case "3":
                                            value = ((ProcessTest) object).getDetectionDevice();
                                            break;
                                        case "4":
                                            value = ((ProcessTest) object).getDeviceType();
                                            break;
                                        case "5":
                                            value = ((ProcessTest) object).getDeviceNum();
                                            break;
                                        case "6":
                                            value = ((ProcessTest) object).getPs();
                                            break;
                                    }
                                    break;
                                case "整机检验报告单":
                                    switch (last) {
                                        case "1":
                                            value = ((MachineTest) object).getData();
                                            break;
                                        case "2":
                                            value = ((MachineTest) object).getResult();
                                            break;
                                        case "3":
                                            value = ((MachineTest) object).getPs();
                                            break;
                                    }
                                    break;
                                case "成品检验报告单":
                                    switch (last) {
                                        case "1":
                                            value = ((ProductTest) object).getData();
                                            break;
                                        case "2":
                                            value = ((ProductTest) object).getResult();
                                            break;
                                        case "3":
                                            value = ((ProductTest) object).getPs();
                                            break;
                                    }
                                    break;
                                case "血压计检定报告单":
                                    switch (last) {
                                        case "1":
                                            value = ((Sphygmomanometer) object).getData();
                                            break;
                                        case "2":
                                            value = ((Sphygmomanometer) object).getResult();
                                            break;
                                        case "3":
                                            value = ((Sphygmomanometer) object).getPs();
                                            break;
                                    }
                                    break;
                                case "性能要求检验单":
                                    switch (last) {
                                        case "1":
                                            value = ((PerformTest) object).getData();
                                            break;
                                        case "2":
                                            value = ((PerformTest) object).getResult();
                                            break;
                                        case "3":
                                            value = ((PerformTest) object).getPs();
                                            break;
                                    }
                                    break;
                                case "最终检验报告单":
                                    String[] strings = ((FinalTest) object).getResult().split("|");
                                    switch (last) {
                                        case "1":
                                            value = strings[0];
                                            break;
                                        case "2":
                                            value = strings[1];
                                            break;
                                    }
                                    break;
                            }
                            setCellStrValue(i, j, value);
                        }
                    }
                }
            }
        }
    }
    /**
     * 根据 Map中的数据替换Excel模板中指定数据
     * @param map     要替换的字符串的MAP
     */
    public void replaceExcelDate(Map<String, String> map){
        // 获取行数
        int rowNum = sheet.getLastRowNum();
        for (int i = 0; i <= rowNum; i++) {
            Row	row = sheet.getRow(i);
            // 获取行里面的总列数
            int columnNum = 0;
            if(row!=null){
                columnNum = row.getPhysicalNumberOfCells();
            }
            for (int j = 0; j < columnNum; j++) {
                XSSFCell cell = (XSSFCell)sheet.getRow(i).getCell(j);
                String cellValue = cell.getStringCellValue();
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    //System.out.println("横坐标:"+i+",纵坐标："+j+",内容："+cellValue);
                    if(key.equals(cellValue)){
                        String value = entry.getValue();
                        setCellStrValue(i, j, value);
                    }
                }
            }
        }
    }
    /**
     * 设置字符串类型的数据
     * @param rowIndex--行值 从0开始
     * @param cellnum--列值  从0开始
     * @param value--字符串类型的数据
     *
     */
    private void setCellStrValue(int rowIndex, int cellnum, String value) {
        XSSFCell cell = (XSSFCell) sheet.getRow(rowIndex).getCell(cellnum);
        cell.setCellValue(value);
    }
    /**
     * 设置图片
     * @param rowIndex--行值 从0开始
     * @param cellnum--列值  从0开始
     * @param JPGpath--图片路径
     */
    private void setCellStrGif(int rowIndex, int cellnum, String JPGpath) {
        try {
            // 打开图片
            InputStream is = new FileInputStream(JPGpath);
            byte[] bytes = IOUtils.toByteArray(is);
            int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();
            Drawing drawing = sheet.createDrawingPatriarch();
            //anchor主要用于设置图片的属性
            ClientAnchor anchor = new XSSFClientAnchor();
            anchor.setCol1(cellnum);
            anchor.setCol2(cellnum+1);
            anchor.setRow1(rowIndex);
            anchor.setRow2(rowIndex+1);
            //插入图片
            drawing.createPicture(anchor, pictureIdx);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
    /**
     * 复制文件
     * @param fromFile   要复制的文件路径
     * @param toFile	 复制的文件的路径
     *
     */
    public void copyFile(File fromFile,File toFile) {
        try {
            FileInputStream ins = new FileInputStream(fromFile);
            FileOutputStream out = new FileOutputStream(toFile);
            byte[] b = new byte[1024];
            int n = 0;
            while ((n = ins.read(b)) != -1) {
                out.write(b, 0, n);
            }
            ins.close();
            out.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
