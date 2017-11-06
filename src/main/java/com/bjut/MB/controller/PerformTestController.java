package com.bjut.MB.controller;

import com.bjut.MB.model.PerformTest;
import com.bjut.MB.service.PerformTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */
//性能要求检验单
@Controller
public class PerformTestController {
    private static final Logger logger = LoggerFactory.getLogger(PerformTestController.class);

    @Autowired
    private PerformTestService performTestService;

    @RequestMapping(value = "/addperformtest")
    @ResponseBody
    public String addAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                           @RequestParam(value = "data") String data, @RequestParam(value = "daresultte") String result,
                           @RequestParam(value = "detectionDevice") String detectionDevice, @RequestParam(value = "deviceType") String deviceType,
                           @RequestParam(value = "deviceNum") String deviceNum, @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = performTestService.addPerformTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        }
        catch (Exception e){
            logger.error("添加性能要求检验单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/updateperformtest")
    @ResponseBody
    public String updateAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data, @RequestParam(value = "daresultte") String result,
                              @RequestParam(value = "detectionDevice") String detectionDevice, @RequestParam(value = "deviceType") String deviceType,
                              @RequestParam(value = "deviceNum") String deviceNum, @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = performTestService.updatePerformTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        }
        catch (Exception e){
            logger.error("更新性能要求检验单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/selectperformtest")
    @ResponseBody
    public String selectAging(@RequestParam(value = "orderNum") String orderNum){
        List<PerformTest> agingList = performTestService.selectPerformTest(orderNum);
        return null;
    }
}
