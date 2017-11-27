package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.FinalTest;
import com.bjut.MB.service.FinalTestService;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */
//
//@Controller
//public class FianlTestController {
//    private static final Logger logger = LoggerFactory.getLogger(FianlTestController.class);
//
//    @Autowired
//    private ExcelUtils excelUtils;
//    @Autowired
//    private FinalTestService finalTestService;
//
//    @RequestMapping(path = "/addfinaltest")
//    @ResponseBody
//    @Transactional(propagation= Propagation.REQUIRED)
//    public String addFinalTest(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
//        Map<String,String> map = new HashMap<>();
//        try {
//            excelUtils.importExcel(path, number,"finaltest");
//            map.put("code","1");
//        }
//        catch (Exception e){
//            logger.error("添加最终检验单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/updatefinaltest")
//    @ResponseBody
//    public String updateFinalTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                                  @RequestParam(value = "result") String result){
//        Map<String,String> map = new HashMap<>();
//        try {
//            String path =finalTestService.selectPath(orderNum);
//            FinalTest finalTest = new FinalTest();
//            finalTest.setResult(result);
//            if(path == null){
//                map.put("code","2");
//                map.put("msg","不存在");
//                return map.toString();
//            }
//            map = excelUtils.replaceExcel(path,"order", process, finalTest);
//        }
//        catch (Exception e){
//            logger.error("更新最终检验单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/selectfinaltest")
//    @ResponseBody
//    public String selectFinalTest(Model model, @RequestParam(value = "orderNum") String orderNum){
//        String path = finalTestService.selectPath(orderNum);
//        return path;
//    }
//
//    @RequestMapping(path = "/deletefinaltest")
//    @ResponseBody
//    public String deleteFinalTest(@RequestParam(value = "orderNum") String orderNum){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = finalTestService.deleteFinalTest(orderNum);
//        } catch (Exception e) {
//            logger.error("删除最终检验单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//}
