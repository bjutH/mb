package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.ProductTest;
import com.bjut.MB.service.ProductTestService;
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
//成品检验报告单
@Controller
public class ProductTestController {
    private static final Logger logger = LoggerFactory.getLogger(ProductTestController.class);

    @Autowired
    private ProductTestService productTestService;

    @RequestMapping(path = "/addproducttest")
    @ResponseBody
    @Transactional(propagation= Propagation.REQUIRED)
    public String addProductTest(@RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
        Map<String,String> map = new HashMap<>();
        try {
            ExcelUtils excelUtils = new ExcelUtils();
            excelUtils.importExcel(path, number,"producttest");
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加成品检验报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

//    @RequestMapping(path = "/updateproducttest")
//    @ResponseBody
//    public String updateProductTest(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
//                                     @RequestParam(value = "data") String data, @RequestParam(value = "result") String result,
//                                     @RequestParam(value = "ps") String ps){
//        Map<String,String> map = new HashMap<>();
//        try {
//            map = productTestService.updateProductTest(orderNum, process, data, result, ps);
//        }
//        catch (Exception e){
//            logger.error("更新成品检验报告单异常" + e.getMessage());
//            map.put("code","3");
//        }
//        return map.toString();
//    }
//
//    @RequestMapping(path = "/selectproducttestall")
//    @ResponseBody
//    public String selectProductTest(Model model, @RequestParam(value = "orderNum") String orderNum){
//        List<ProductTest> productTestList = productTestService.selectProductTest(orderNum);
//        return null;
//    }
//
//    @RequestMapping(path = "/selectproducttest")
//    @ResponseBody
//    public String selectProductTest(Model model, @RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process){
//        ProductTest productTest = productTestService.selectProductTest(orderNum, process);
//        return null;
//    }

    @RequestMapping(path = "/selectproducttest")
    @ResponseBody
    public String selectProductTest(Model model, @RequestParam(value = "orderNum") String orderNum){
        String path = productTestService.selectPath(orderNum);
        return path;
    }

    @RequestMapping(path = "/deleteproducttest")
    @ResponseBody
    public String deleteProductTest(@RequestParam(value = "orderNum") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = productTestService.deleteProductTest(orderNum);
        } catch (Exception e) {
            logger.error("删除成品检验报告单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
