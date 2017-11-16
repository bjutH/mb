package com.bjut.MB.Utils;

import com.bjut.MB.dao.OrderDao;
import com.bjut.MB.dao.YiqiDao;
import com.bjut.MB.model.Memo;
import com.bjut.MB.model.Order;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Map;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;
import static java.lang.System.out;

/**
 * Created by Administrator on 2017/11/14.
 */
public class ExcelUtils {
    private org.apache.poi.ss.usermodel.Sheet sheet;
    private Workbook wb;

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private YiqiDao yiqiDao;


    /**
     *
     * @param modelPath  EXCEL文件路径
     * @param x			随工单编号的横坐标
     * @param y			随工单编号的纵坐标
     */
    public void importExcel(String modelPath,int x,int y){
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
        String id = null;
        String process = null;
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
                String cellValue = cell.getStringCellValue();
                if(i==x &&j==y){
                    id = cellValue;
                }
                if(cellValue.contains("$")){
                    process = cellValue.substring(1, cellValue.length());
                    orderDao.addItem(id, process);
                }
            }
        }
    }

    /**
     * 替换EXCEL文件内容
     * @param modelPath EXCEL文件路径
     * @param x          随工单编号的横坐标
     * @param y          随工单编号的纵坐标
     * @param type       哪张表单
     */
    public void replaceExcel(String modelPath, int x, int y, String type){
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
        replaceDate(x, y, type);
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
     * 根据ID查询内容并替换
     * @param x         随工单编号的横坐标
     * @param y         随工单编号的纵坐标
     * @param type      哪张表单
     */
    private void replaceDate(int x, int y, String type){
        // 获取行数
        int rowNum = sheet.getLastRowNum();
        String id = null;
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
                if(i==x &&j==y){
                    id = cellValue;
                }
                String first = String.valueOf(cellValue.charAt(0));
                String last = String.valueOf(cellValue.charAt(cellValue.length()));
                if(first=="#"){
                    String value = null;
                    String string = cellValue.substring(1, cellValue.length()-1);
                    switch (type){
                        case "order":
                            //Order order = orderDao.selectItem(id,string);
                            switch (last){
                                case "1":
                                    value = order.getOperater();
                                    break;
                                case  "2":
                                    value = order.getOther();
                                    break;
                                case  "3":
                                    value = order.getPs();
                                    break;
                            }
                            break;
                        case  "memo":
                            //Memo memo = yiqiDao.selectItem(id,string);
                            switch (last){
                                case "1":
                                    value = memo.getNumber();
                                    break;
                                case "2":
                                    value = memo.getBoardNum();
                                    break;
                                case  "3":
                                    value = memo.getWeld();
                                    break;
                                case  "4":
                                    value = memo.getDebug();
                                    break;
                                case "5":
                                    value = memo.getTest();
                                    break;
                                case "6":
                                    value = memo.getVersion();
                                    break;
                                case "7":
                                    value = memo.getPs();
                                    break;
                            }
                            break;
                        case "aging":

                    }
                    setCellStrValue(i, j, value);
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
