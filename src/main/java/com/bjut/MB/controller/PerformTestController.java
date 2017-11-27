package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.PerformTest;
import com.bjut.MB.service.PerformTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */
//
//@Controller
//public class PerformTestController {
//    private static final Logger logger = LoggerFactory.getLogger(PerformTestController.class);
//
//    @Autowired
//    private ExcelUtils excelUtils;
//    @Autowired
//    private PerformTestService performTestService;
//
//    @RequestMapping(path = "/addperformtest")
//    @ResponseBody
//    @Transactional(propagation= Propagation.REQUIRED)
//    public String addPerformTest(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
//        Map<String,String> map = new HashMap<>();
//        try {
//            excelUtils.importExcel(path, number,"performtest");
//            map.put("code","1");
//        }
//        catch (Exception e){
//            logger.error("添加性能要求检验单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/updateperformtest")
//    @ResponseBody
//    public String updatePerformTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                                     @RequestParam(value = "data") String data, @RequestParam(value = "result") String result,
//                                     @RequestParam(value = "ps") String ps){
//        Map<String,String> map = new HashMap<>();
//        try {
//            String path =performTestService.selectPath(orderNum);
//            PerformTest performTest = new PerformTest();
//            performTest.setData(data);
//            performTest.setResult(result);
//            performTest.setPs(ps);
//            if(path == null){
//                map.put("code","2");
//                map.put("msg","不存在");
//                return map.toString();
//            }
//            map = excelUtils.replaceExcel(path,"order", process, performTest);
//        }
//        catch (Exception e){
//            logger.error("更新性能要求检验单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/selectperformtest")
//    @ResponseBody
//    public String selectPerformTest(Model model, @RequestParam(value = "orderNum") String orderNum){
//        String path = performTestService.selectPath(orderNum);
//        return path;
//    }
//
//    @RequestMapping(path = "/deleteperformtest")
//    @ResponseBody
//    public String deletePerformTest(@RequestParam(value = "orderNum") String orderNum){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = performTestService.deletePerformTest(orderNum);
//        } catch (Exception e) {
//            logger.error("删除性能要求检验单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//}
