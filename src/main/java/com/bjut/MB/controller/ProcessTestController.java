package com.bjut.MB.controller;

import com.bjut.MB.model.ProcessTest;
import com.bjut.MB.service.ProcessTestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
//工序检验报告单
@Controller
public class ProcessTestController {
    private static final Logger logger = LoggerFactory.getLogger(ProcessTestController.class);

    @Autowired
    private ProcessTestService processTestService;

    @RequestMapping(value = "/addprocesstest")
    @ResponseBody
    public String addProcessTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process){
        Map<String,String> map = new HashMap<>();
        try {
            map = processTestService.addProcessTest(orderNum, process);
        }
        catch (Exception e){
            logger.error("添加关键工序检验报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(value = "/updateprocesstest")
    @ResponseBody
    public String updateProcessTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                                    @RequestParam(value = "data") String data, @RequestParam(value = "result") String result,
                                    @RequestParam(value = "detectionDevice") String detectionDevice, @RequestParam(value = "deviceType") String deviceType,
                                    @RequestParam(value = "deviceNum") String deviceNum, @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = processTestService.updateProcessTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        }
        catch (Exception e){
            logger.error("更新关键工序检验报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(value = "/selectprocesstestall")
    @ResponseBody
    public String selectProcessTest(Model model, @RequestParam(value = "orderNum") String orderNum){
        List<ProcessTest> processTestList = processTestService.selectProcessTest(orderNum);
        return null;
    }

    @RequestMapping(value = "/selectprocesstest")
    @ResponseBody
    public String selectProcessTest(Model model, @RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process){
        ProcessTest processTest = processTestService.selectProcessTest(orderNum, process);
        return null;
    }

    @RequestMapping(value = "/deleteprocesstest")
    @ResponseBody
    public String deleteProcessTest(@RequestParam(value = "orderNum") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = processTestService.deleteProcessTest(orderNum);
        } catch (Exception e) {
            logger.error("删除关键工序检验报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
