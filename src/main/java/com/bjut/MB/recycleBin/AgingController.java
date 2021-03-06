package com.bjut.MB.recycleBin;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Aging;
import com.bjut.MB.service.AgingService;
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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 */
//
//@Controller
//public class AgingController {
//    private static final Logger logger = LoggerFactory.getLogger(AgingController.class);
//
//    @Autowired
//    private ExcelUtils excelUtils;
//    @Autowired
//    private AgingService agingService;
//
//    @RequestMapping(path = "/addaging")
//    @ResponseBody
//    @Transactional(propagation= Propagation.REQUIRED)
//    public String addAging(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
//        Map<String,String> map = new HashMap<>();
//        try {
//            excelUtils.importExcel(path, number,"aging");
//            map.put("code","1");
//        }
//        catch (Exception e){
//            logger.error("添加老化观测表异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/updateaging")
//    @ResponseBody
//    public String updateAging(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                              @RequestParam(value = "result") String result, @RequestParam(value = "date") Date date,
//                              @RequestParam(value = "phenomenon") String phenomenon, @RequestParam(value = "handle") String handle,
//                              @RequestParam(value = "ps") String ps, @RequestParam(value = "operater") String operater){
//        Map<String,String> map = new HashMap<>();
//        try {
//            String path =agingService.selectPath(orderNum);
//            Aging aging = new Aging();
//            aging.setResult(result);
//            aging.setDate(date);
//            aging.setPhenomenon(phenomenon);
//            aging.setHandle(handle);
//            aging.setPs(ps);
//            aging.setOperater(operater);
//            if(path == null){
//                map.put("code","2");
//                map.put("msg","不存在");
//                return map.toString();
//            }
//            map = excelUtils.replaceExcel(path,"order", process, aging);
//        }
//        catch (Exception e){
//            logger.error("更新老化观测表异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/selectaging")
//    @ResponseBody
//    public String selectAging(Model model, @RequestParam(value = "orderNum") String orderNum){
//        String path = agingService.selectPath(orderNum);
//        return path;
//    }
//
//    @RequestMapping(path = "/deleteaging")
//    @ResponseBody
//    public String deleteAging(@RequestParam(value = "orderNum") String orderNum){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = agingService.deleteAging(orderNum);
//        } catch (Exception e) {
//            logger.error("删除老化观测表异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//}
