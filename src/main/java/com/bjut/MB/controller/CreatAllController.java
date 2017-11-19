package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/19.
 */
@Controller
public class CreatAllController {
    private static final Logger logger = LoggerFactory.getLogger(CreatAllController.class);


    @Autowired
    private RemadeSercice remadeSercice;

    /**
     * 一次添加全部随工单表格
     * @param path      路径
     * @param number    随工单编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    @RequestMapping(value = "/addall")
    @ResponseBody
    @Transactional(propagation= Propagation.REQUIRED)
    public String addAging(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
        Map<String,String> map = new HashMap<>();
        ExcelUtils excelUtils = new ExcelUtils();
        String filePath = null;
        try {
            filePath = path + "//1.xlsx";
            excelUtils.importExcel(filePath, number,"order");

            filePath = path + "//2.xlsx";
            excelUtils.importExcel(filePath, number,"memo");

            filePath = path + "//3.xlsx";
            remadeSercice.addRemade(number,null,null,null,null,null,null,null, path);

            filePath = path + "//4.xlsx";
            excelUtils.importExcel(filePath, number,"aging");

            filePath = path + "//5.xlsx";
            excelUtils.importExcel(filePath, number,"pack");

            filePath = path + "//6.xlsx";
            excelUtils.importExcel(filePath, number,"debug");

            filePath = path + "//7.xlsx";
            excelUtils.importExcel(filePath, number,"processtest");

            filePath = path + "//8.xlsx";
            excelUtils.importExcel(filePath, number,"machinetest");

            filePath = path + "//9.xlsx";
            excelUtils.importExcel(filePath, number,"producttest");

            filePath = path + "//10.xlsx";
            excelUtils.importExcel(filePath, number,"sphygmomanometer");

            filePath = path + "//11.xlsx";
            excelUtils.importExcel(filePath, number,"performtest");

            filePath = path + "//12.xlsx";
            excelUtils.importExcel(filePath, number,"finaltest");
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
