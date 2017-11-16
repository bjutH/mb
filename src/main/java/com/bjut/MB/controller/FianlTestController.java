package com.bjut.MB.controller;

import com.bjut.MB.model.FinalTest;
import com.bjut.MB.service.FinalTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
//最终检验报告单
@Controller
public class FianlTestController {
    private static final Logger logger = LoggerFactory.getLogger(FianlTestController.class);

    @Autowired
    private FinalTestService finalTestService;

    @RequestMapping(value = "/addfinaltest")
    @ResponseBody
    public String addFinalTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                               @RequestParam(value = "machineType") String machineType, @RequestParam(value = "lable") String lable,
                               @RequestParam(value = "check") String check, @RequestParam(value = "checker") String checker,
                               @RequestParam(value = "date") Date date, @RequestParam(value = "finalChecker") String finalChecker,
                               @RequestParam(value = "finalDate") Date finalDate, @RequestParam(value = "result") String result){
        Map<String,String> map = new HashMap<>();
        try {
            map = finalTestService.addFinalTest(orderNum, process, machineType, lable, check, checker, date, finalChecker, finalDate, result);
        }
        catch (Exception e){
            logger.error("添加最终检验单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(value = "/updatefinaltest")
    @ResponseBody
    public String updateFinalTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                                  @RequestParam(value = "machineType") String machineType, @RequestParam(value = "lable") String lable,
                                  @RequestParam(value = "check") String check, @RequestParam(value = "checker") String checker,
                                  @RequestParam(value = "date") Date date, @RequestParam(value = "finalChecker") String finalChecker,
                                  @RequestParam(value = "finalDate") Date finalDate, @RequestParam(value = "result") String result){
        Map<String,String> map = new HashMap<>();
        try {
            map = finalTestService.updateFinalTest(orderNum, process, machineType, lable, check, checker, date, finalChecker, finalDate, result);
        }
        catch (Exception e){
            logger.error("更新最终检验单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(value = "/selectfinaltest")
    @ResponseBody
    public String selectFinalTest(Model model, @RequestParam(value = "orderNum") String orderNum){
        List<FinalTest> agingList = finalTestService.selectFinalTest(orderNum);
        return null;
    }

    @RequestMapping(value = "/deletefinaltest")
    @ResponseBody
    public String deleteFinalTest(@RequestParam(value = "orderNum") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = finalTestService.deleteFinalTest(orderNum);
        } catch (Exception e) {
            logger.error("删除最终检验单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
