package com.bjut.MB.recycleBin;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.ProcessTest;
import com.bjut.MB.model.ProductTest;
import com.bjut.MB.service.ProcessTestService;
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
//public class ProcessTestController {
//    private static final Logger logger = LoggerFactory.getLogger(ProcessTestController.class);
//
//    @Autowired
//    private ExcelUtils excelUtils;
//    @Autowired
//    private ProcessTestService processTestService;
//
//    @RequestMapping(path = "/addprocesstest")
//    @ResponseBody
//    @Transactional(propagation= Propagation.REQUIRED)
//    public String addProcessTest(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
//        Map<String,String> map = new HashMap<>();
//        try {
//            excelUtils.importExcel(path, number,"processtest");
//            map.put("code","1");
//        }
//        catch (Exception e){
//            logger.error("添加关键工序检验报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/updateprocesstest")
//    @ResponseBody
//    public String updateProcessTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                                    @RequestParam(value = "data") String data, @RequestParam(value = "result") String result,
//                                    @RequestParam(value = "detectionDevice") String detectionDevice, @RequestParam(value = "deviceType") String deviceType,
//                                    @RequestParam(value = "deviceNum") String deviceNum, @RequestParam(value = "ps") String ps){
//        Map<String,String> map = new HashMap<>();
//        try {
//            String path =processTestService.selectPath(orderNum);
//            ProcessTest processTest = new ProcessTest();
//            processTest.setData(data);
//            processTest.setResult(result);
//            processTest.setDetectionDevice(detectionDevice);
//            processTest.setDeviceType(deviceType);
//            processTest.setDeviceNum(deviceNum);
//            processTest.setPs(ps);
//            if(path == null){
//                map.put("code","2");
//                map.put("msg","不存在");
//                return map.toString();
//            }
//            map = excelUtils.replaceExcel(path,"order", process, processTest);
//        }
//        catch (Exception e){
//            logger.error("更新关键工序检验报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(value = "/selectprocesstest")
//    @ResponseBody
//    public String selectProcessTest(Model model, @RequestParam(value = "orderNum") String orderNum){
//        String path = processTestService.selectPath(orderNum);
//        return path;
//    }
//
//    @RequestMapping(path = "/deleteprocesstest")
//    @ResponseBody
//    public String deleteProcessTest(@RequestParam(value = "orderNum") String orderNum){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = processTestService.deleteProcessTest(orderNum);
//        } catch (Exception e) {
//            logger.error("删除关键工序检验报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//}
