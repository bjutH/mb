package com.bjut.MB.Utils;

import com.bjut.MB.dao.*;
import com.bjut.MB.model.*;
import com.bjut.MB.service.*;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;
import static java.lang.System.out;
import static java.lang.System.setOut;

/**
 * Created by Administrator on 2017/11/14.
 */
@Service
public class ExcelUtils {
    private org.apache.poi.ss.usermodel.Sheet sheet;
    private Workbook wb;

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private YiqiDao yiqiDao;
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
                if(cellValue.contains("@")){
                    process = cellValue.substring(1, cellValue.length());
                    switch (process){
                        case "number":
                            value = number;
                            setCellStrValue(i, j, value);
                        case "lable":
                            value = number;
                            setCellStrValue(i, j, value);
                    }
                }
                if(cellValue.contains("$")){
                    process = cellValue.substring(1, cellValue.length());
                    switch (type){
                        case "order":
                            orderDao.addItem(id, process, modelPath);
                            break;
                        case  "memo":
                            yiqiDao.addItem(id, process, modelPath);
                            break;
                        case "aging":
                            agingDao.addItem(id, process, modelPath);
                            break;
                        case "pack":
                            packDao.addItem(id, process, modelPath);
                            break;
                        case "debug":
                            debugDao.addItem(id, process, modelPath);
                            break;
                        case "processTest":
                            processTestDao.addItem(id, process, modelPath);
                            break;
                        case "machineTest":
                            machineTestDao.addItem(id, process, modelPath);
                            break;
                        case "productTest":
                            processTestDao.addItem(id, process, modelPath);
                            break;
                        case "sphygmomanometer":
                            sphygmomanometerDao.addItem(id, process, modelPath);
                            break;
                        case "performTest":
                            performTestDao.addItem(id, process, modelPath);
                            break;
                        case "finalTest":
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
                    if(first.equals("#")) {
                        String last = String.valueOf(cellValue.charAt(cellValue.length() - 1));
                        String value = null;
                        String string = cellValue.substring(1, cellValue.length() - 1);
                        if (string.equals(process)) {
                            switch (type) {
                                case "order":
                                    switch (last) {
                                        case "1":
                                            value = ((Order) object).getOperater();
                                            break;
                                        case "2":
                                            value = ((Order) object).getOther();
                                            break;
                                        case "3":
                                            value = ((Order) object).getPs();
                                            break;
                                    }
                                    break;
                                case "memo":
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
                                case "aging":
                                    switch (last) {
                                        case "1":
                                            value = ((Aging) object).getResult();
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
                                            value = ((Aging) object).getOperater();
                                            break;
                                    }
                                    break;
                                case "pack":
                                    switch (last) {
                                        case "1":
                                            value = ((Pack) object).getResult();
                                            break;
                                        case "2":
                                            value = ((Pack) object).getCheck();
                                            break;
                                        case "3":
                                            value = ((Pack) object).getOperater();
                                            break;
                                    }
                                    break;
                                case "debug":
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
                                case "processTest":
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
                                case "machineTest":
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
                                case "productTest":
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
                                case "sphygmomanometer":
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
                                case "performTest":
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
                                case "finalTest":
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
                XSSFCell cell = (XSSFCell) sheet.getRow(i).getCell(j);
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
