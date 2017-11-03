package com.bjut.MB.controller;

import com.bjut.MB.model.Aging;
import com.bjut.MB.service.AgingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 */

//老化观测表
@Controller
public class AgingController {
    private static final Logger logger = LoggerFactory.getLogger(AgingController.class);

    @Autowired
    private AgingService agingService;

    @RequestMapping(value = "/addaging")
    @ResponseBody
    public String addAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                          @RequestParam(value = "result") String result, @RequestParam(value = "date") Date date,
                          @RequestParam(value = "phenomenon") String phenomenon, @RequestParam(value = "handle") String handle,
                          @RequestParam(value = "phenomenon") String ps, @RequestParam(value = "handle") String operater){
        Map<String,String> map = new HashMap<>();
        try {
            map = agingService.addAging(orderNum, process, result, date, phenomenon, handle, ps, operater);
        }
        catch (Exception e){
            logger.error("添加老化观测表异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/updateaging")
    @ResponseBody
    public String updateAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                              @RequestParam(value = "result") String result, @RequestParam(value = "date") Date date,
                              @RequestParam(value = "phenomenon") String phenomenon, @RequestParam(value = "handle") String handle,
                              @RequestParam(value = "phenomenon") String ps, @RequestParam(value = "handle") String operater){
        Map<String,String> map = new HashMap<>();
        try {
            map = agingService.updateAging(orderNum, process, result, date, phenomenon, handle, ps, operater);
        }
        catch (Exception e){
            logger.error("更新老化观测表异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
    @RequestMapping(value = "/selectaging")
    @ResponseBody
    public String selectAging(@RequestParam(value = "orderNum") String orderNum){
        List<Aging> agingList = agingService.selectAging(orderNum);
        return null;
    }
}
