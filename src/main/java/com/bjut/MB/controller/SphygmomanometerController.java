package com.bjut.MB.controller;

import com.bjut.MB.model.Sphygmomanometer;
import com.bjut.MB.service.SphygmomanometerService;
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
//血压计鉴定报告单
@Controller
public class SphygmomanometerController {
    private static final Logger logger = LoggerFactory.getLogger(SphygmomanometerController.class);

    @Autowired
    private SphygmomanometerService sphygmomanometerService;

    @RequestMapping(value = "/addsphygmomanometer")
    @ResponseBody
    public String addSphygmomanometer(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process){
        Map<String,String> map = new HashMap<>();
        try {
            map = sphygmomanometerService.addSphygmomanometer(orderNum, process);
        }
        catch (Exception e){
            logger.error("添加血压计检定报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(value = "/updatesphygmomanometer")
    @ResponseBody
    public String updateSphygmomanometer(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                                          @RequestParam(value = "data") String data, @RequestParam(value = "result") String result,
                                          @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = sphygmomanometerService.updateSphygmomanometer(orderNum, process, data, result, ps);
        }
        catch (Exception e){
            logger.error("更新血压计检定报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(value = "/selectsphygmomanometerall")
    @ResponseBody
    public String selectSphygmomanometer(Model model, @RequestParam(value = "orderNum") String orderNum){
        List<Sphygmomanometer> sphygmomanometerList = sphygmomanometerService.selectSphygmomanometer(orderNum);
        return null;
    }

    @RequestMapping(value = "/selectsphygmomanometer")
    @ResponseBody
    public String selectSphygmomanometer(Model model, @RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process){
        Sphygmomanometer sphygmomanometer = sphygmomanometerService.selectSphygmomanometer(orderNum, process);
        return null;
    }

    @RequestMapping(value = "/deletesphygmomanometer")
    @ResponseBody
    public String deleteSphygmomanometer(@RequestParam(value = "orderNum") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = sphygmomanometerService.deleteSphygmomanometer(orderNum);
        } catch (Exception e) {
            logger.error("删除血压计检定报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
