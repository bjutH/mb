package com.bjut.MB.controller;

import com.bjut.MB.model.MachineTest;
import com.bjut.MB.service.MachineTestService;
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
@Controller
public class MachineTestController {
    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);

    @Autowired
    private MachineTestService machineTestService;

    @RequestMapping(value = "/adddemachineTest")
    @ResponseBody
    public String addAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                           @RequestParam(value = "data") String data, @RequestParam(value = "daresultte") String result,
                           @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = machineTestService.addMachineTest(orderNum, process, data, result, ps);
        }
        catch (Exception e){
            logger.error("添加整机检验报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/updatedebug")
    @ResponseBody
    public String updateAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                              @RequestParam(value = "data") String data, @RequestParam(value = "daresultte") String result,
                              @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = machineTestService.updateMachineTest(orderNum, process, data, result, ps);
        }
        catch (Exception e){
            logger.error("更新整机检验报告单异常异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/selectdebug")
    @ResponseBody
    public String selectAging(@RequestParam(value = "orderNum") String orderNum){
        List<MachineTest> agingList = machineTestService.selectMachineTest(orderNum);
        return null;
    }
}
