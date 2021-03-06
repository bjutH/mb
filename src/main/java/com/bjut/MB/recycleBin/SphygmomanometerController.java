package com.bjut.MB.recycleBin;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Sphygmomanometer;
import com.bjut.MB.service.SphygmomanometerService;
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
//public class SphygmomanometerController {
//    private static final Logger logger = LoggerFactory.getLogger(SphygmomanometerController.class);
//
//    @Autowired
//    private ExcelUtils excelUtils;
//    @Autowired
//    private SphygmomanometerService sphygmomanometerService;
//
//    @RequestMapping(path = "/addsphygmomanometer")
//    @ResponseBody
//    @Transactional(propagation= Propagation.REQUIRED)
//    public String addSphygmomanometer(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
//        Map<String,String> map = new HashMap<>();
//        try {
//            excelUtils.importExcel(path, number,"sphygmomanometer");
//            map.put("code","1");
//        }
//        catch (Exception e){
//            logger.error("添加血压计检定报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/updatesphygmomanometer")
//    @ResponseBody
//    public String updateSphygmomanometer(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                                          @RequestParam(value = "data") String data, @RequestParam(value = "result") String result,
//                                          @RequestParam(value = "ps") String ps){
//        Map<String,String> map = new HashMap<>();
//        try {
//            String path =sphygmomanometerService.selectPath(orderNum);
//            Sphygmomanometer sphygmomanometer = new Sphygmomanometer();
//            sphygmomanometer.setData(data);
//            sphygmomanometer.setResult(result);
//            sphygmomanometer.setPs(ps);
//            if(path == null){
//                map.put("code","2");
//                map.put("msg","不存在");
//                return map.toString();
//            }
//            map = excelUtils.replaceExcel(path,"order", process, sphygmomanometer);
//        }
//        catch (Exception e){
//            logger.error("更新血压计检定报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/selectsphygmomanometer")
//    @ResponseBody
//    public String selectSphygmomanometer(Model model, @RequestParam(value = "orderNum") String orderNum){
//        String path = sphygmomanometerService.selectPath(orderNum);
//        return path;
//    }
//
//    @RequestMapping(path = "/deletesphygmomanometer")
//    @ResponseBody
//    public String deleteSphygmomanometer(@RequestParam(value = "orderNum") String orderNum){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = sphygmomanometerService.deleteSphygmomanometer(orderNum);
//        } catch (Exception e) {
//            logger.error("删除血压计检定报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//}
