package com.bjut.MB.controller;

import com.bjut.MB.model.Remade;
import com.bjut.MB.service.RemadeSercice;
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
 * Created by Administrator on 2017/11/3.
 */

//返工记录表
@Controller
public class RemadeController {
    private static final Logger logger = LoggerFactory.getLogger(RemadeController.class);

    @Autowired
    private RemadeSercice remadeSercice;

    @RequestMapping(value = "/addremade")
    @ResponseBody
    public String addRemade(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "date") Date date,
                          @RequestParam(value = "number") String number, @RequestParam(value = "updateSoftware") String updateSoftware,
                          @RequestParam(value = "updateHardware") String updateHardware, @RequestParam(value = "updateContent") String updateContent,
                          @RequestParam(value = "updatePeople") String updatePeople, @RequestParam(value = "testPeople") String testPeople){
        Map<String,String> map = new HashMap<>();
        try {
            map = remadeSercice.addRemade(orderNum, date, number, updateSoftware, updateHardware, updateContent, updatePeople, testPeople);
        }
        catch (Exception e){
            logger.error("添加返工记录表异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(value = "/updateremade")
    @ResponseBody
    public String updateRemade(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "date") Date date,
                             @RequestParam(value = "number") String number, @RequestParam(value = "updateSoftware") String updateSoftware,
                             @RequestParam(value = "updateHardware") String updateHardware, @RequestParam(value = "updateContent") String updateContent,
                             @RequestParam(value = "updatePeople") String updatePeople, @RequestParam(value = "testPeople") String testPeople){
        Map<String,String> map = new HashMap<>();
        try {
            map = remadeSercice.updateRemade(orderNum, date, number, updateSoftware, updateHardware, updateContent, updatePeople, testPeople);
        }
        catch (Exception e){
            logger.error("更新返工记录表异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(value = "/selectmemo")
    @ResponseBody
    public String selectRemade(Model model, @RequestParam(value = "orderNum") String orderNum){
        List<Remade> remadeList = remadeSercice.selectRemade(orderNum);
        return null;
    }

    @RequestMapping(value = "/deleteremade")
    @ResponseBody
    public String deleteRemade(@RequestParam(value = "orderNum") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = remadeSercice.deleteRemade(orderNum);
        } catch (Exception e) {
            logger.error("删除返工记录表异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
