package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Pack;
import com.bjut.MB.service.PackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by Administrator on 2017/11/3.
 */

//装箱记录单
public class PackController {
    private static final Logger logger = LoggerFactory.getLogger(AgingController.class);

    @Autowired
    private PackService packService;

    @RequestMapping(path = "/addpack")
    @ResponseBody
    @Transactional(propagation= Propagation.REQUIRED)
    public String addPack(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
        Map<String,String> map = new HashMap<>();
        try {
            ExcelUtils excelUtils = new ExcelUtils();
            excelUtils.importExcel(path, number,"pack");
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加装箱记录单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

//    @RequestMapping(path = "/updatepack")
//    @ResponseBody
//    public String updatePack(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                              @RequestParam(value = "result") String result, @RequestParam(value = "check") String check,
//                              @RequestParam(value = "operater") String operater){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = packService.updatePack(orderNum, process, result, check, operater);
//        }
//        catch (Exception e){
//            logger.error("更新装箱记录单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/selectpackall")
//    @ResponseBody
//    public String selectPack(Model model, @RequestParam(value = "orderNum") String orderNum){
//        List<Pack> packList = packService.selectPack(orderNum);
//        return null;
//    }
//
//    @RequestMapping(path = "/selectpack")
//    @ResponseBody
//    public String selectPack(Model model, @RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process){
//        Pack pack = packService.selectPack(orderNum, process);
//        return null;
//    }
    @RequestMapping(path = "/selectpack")
    @ResponseBody
    public String selectPack(Model model, @RequestParam(value = "orderNum") String orderNum){
        String path = packService.selectPath(orderNum);
        return path;
    }


    @RequestMapping(path = "/deletepack")
    @ResponseBody
    public String deletePack(@RequestParam(value = "orderNum") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = packService.deletePack(orderNum);
        } catch (Exception e) {
            logger.error("删除装箱记录单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
