package com.bjut.MB.recycleBin;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.MachineTest;
import com.bjut.MB.service.MachineTestService;
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
//public class MachineTestController {
//    private static final Logger logger = LoggerFactory.getLogger(DebugController.class);
//
//    @Autowired
//    private ExcelUtils excelUtils;
//    @Autowired
//    private MachineTestService machineTestService;
//
//    @RequestMapping(path = "/addmachinetest")
//    @ResponseBody
//    @Transactional(propagation= Propagation.REQUIRED)
//    public String addMachineTest(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
//        Map<String,String> map = new HashMap<>();
//        try {
//            excelUtils.importExcel(path, number,"machinetest");
//            map.put("code","1");
//        }
//        catch (Exception e){
//            logger.error("添加整机检验报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/updatemachinetest")
//    @ResponseBody
//    public String updateMachineTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                              @RequestParam(value = "data") String data, @RequestParam(value = "result") String result,
//                              @RequestParam(value = "ps") String ps){
//        Map<String,String> map = new HashMap<>();
//        try {
//            String path =machineTestService.selectPath(orderNum);
//            MachineTest machineTest = new MachineTest();
//            machineTest.setData(data);
//            machineTest.setResult(result);
//            machineTest.setPs(ps);
//            if(path == null){
//                map.put("code","2");
//                map.put("msg","不存在");
//                return map.toString();
//            }
//            map = excelUtils.replaceExcel(path,"order", process, machineTest);
//        }
//        catch (Exception e){
//            logger.error("更新整机检验报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/selectmachinetest")
//    @ResponseBody
//    public String selectMachineTest(Model model, @RequestParam(value = "orderNum") String orderNum){
//        String path = machineTestService.selectPath(orderNum);
//        return path;
//    }
//
//    @RequestMapping(path = "/deletemachinetest")
//    @ResponseBody
//    public String deleteMachineTest(@RequestParam(value = "orderNum") String orderNum){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = machineTestService.deleteMachineTest(orderNum);
//        } catch (Exception e) {
//            logger.error("删除整机检验报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//}
