package com.bjut.MB.controller;

import com.bjut.MB.model.Debug;
import com.bjut.MB.service.DebugService;
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
//整机调试报告单
@Controller
public class DebugController {
    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    @Autowired
    private DebugService debugService;

    @RequestMapping(value = "/adddebug")
    @ResponseBody
    public String addAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                           @RequestParam(value = "data") String data, @RequestParam(value = "daresultte") String result,
                           @RequestParam(value = "detectionDevice") String detectionDevice, @RequestParam(value = "deviceType") String deviceType,
                           @RequestParam(value = "deviceNum") String deviceNum, @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = debugService.addDebug(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        }
        catch (Exception e){
            logger.error("添加整机调试报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/updatedebug")
    @ResponseBody
    public String updateAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data, @RequestParam(value = "daresultte") String result,
                              @RequestParam(value = "detectionDevice") String detectionDevice, @RequestParam(value = "deviceType") String deviceType,
                              @RequestParam(value = "deviceNum") String deviceNum, @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = debugService.updateDebug(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        }
        catch (Exception e){
            logger.error("更新整机调试报告单异常异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/selectdebug")
    @ResponseBody
    public String selectAging(@RequestParam(value = "orderNum") String orderNum){
        List<Debug> agingList = debugService.selectDebug(orderNum);
        return null;
    }
}
