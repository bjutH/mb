package com.bjut.MB.recycleBin;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Debug;
import com.bjut.MB.service.DebugService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */
//
//@Controller
//public class DebugController {
//    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);
//
//    @Autowired
//    private ExcelUtils excelUtils;
//    @Autowired
//    private DebugService debugService;
//
//    @RequestMapping(path = "/adddebug")
//    @ResponseBody
//    @Transactional(propagation= Propagation.REQUIRED)
//    public String addDebug(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
//        Map<String,String> map = new HashMap<>();
//        try {
//            excelUtils.importExcel(path, number,"debug");
//            map.put("code","1");
//        }
//        catch (Exception e){
//            logger.error("添加整机调试报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/updatedebug")
//    @ResponseBody
//    public String updateDebug(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                              @RequestParam(value = "data") String data, @RequestParam(value = "result") String result,
//                              @RequestParam(value = "detectionDevice") String detectionDevice, @RequestParam(value = "deviceType") String deviceType,
//                              @RequestParam(value = "deviceNum") String deviceNum, @RequestParam(value = "ps") String ps){
//        Map<String,String> map = new HashMap<>();
//        try {
//            String path =debugService.selectPath(orderNum);
//            Debug debug = new Debug();
//            debug.setData(data);
//            debug.setResult(result);
//            debug.setDetectionDevice(detectionDevice);
//            debug.setDeviceType(deviceType);
//            debug.setDeviceNum(deviceNum);
//            debug.setPs(ps);
//            if(path == null){
//                map.put("code","2");
//                map.put("msg","不存在");
//                return map.toString();
//            }
//            map = excelUtils.replaceExcel(path,"order", process, debug);
//        }
//        catch (Exception e){
//            logger.error("更新整机调试报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/selectdebug")
//    @ResponseBody
//    public String selectDebug(Model model, @RequestParam(value = "orderNum") String orderNum){
//        String path = debugService.selectPath(orderNum);
//        return path;
//    }
//
//    @RequestMapping(path = "/deletedebug")
//    @ResponseBody
//    public String deleteDebug(@RequestParam(value = "orderNum") String orderNum){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = debugService.deleteDebug(orderNum);
//        } catch (Exception e) {
//            logger.error("删除整机调试报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//}
