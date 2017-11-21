package com.bjut.MB.controller;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Order;
import com.bjut.MB.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/31.
 */

//随工单表
@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private ExcelUtils excelUtils;
    @Autowired
    private OrderService orderService;

    @RequestMapping(path = {"/home"})
    public String home(){
        return "homepage";
    }
    @RequestMapping(path = {"/add"})
    public String add(){
        return "testadd";
    }
    @RequestMapping(path = {"/update"})
    public String update(){
        return "testupdate";
    }
    @RequestMapping(path = {"/select"})
    public String select(){
        return "testselect";
    }
    @RequestMapping(path = "/addorder")
    @ResponseBody
    @Transactional(propagation= Propagation.REQUIRED)
    public String addOrder( @RequestParam(value = "path") String path, @RequestParam(value = "number") String number){
        Map<String,String> map = new HashMap<>();
        try {
            excelUtils.importExcel(path, number,"order");
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加随工单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(path = "/updateorder")
    @ResponseBody
    public String updateOrder(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                               @RequestParam(value = "operater") String operater, @RequestParam(value = "other") String other,
                               @RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            String path =orderService.selectPath(orderNum);
            Order order = new Order();
            order.setOperater(operater);
            order.setOther(other);
            order.setPs(ps);
            if(path == null){
                map.put("code","2");
                map.put("msg","不存在");
                return map.toString();
            }
            map = excelUtils.replaceExcel(path,"order", process, order);
        }
        catch (Exception e) {
            logger.error("更新随工单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }

    @RequestMapping(path = "/selectorder")
    @ResponseBody
    public String selectOrder(Model model, @RequestParam(value = "orderNum") String orderNum){
        String path = orderService.selectPath(orderNum);
        return path;
    }

    @RequestMapping(path = "/selectorderprocess")
    @ResponseBody
    public String selectOrderProcess(Model model, @RequestParam(value = "orderNum") String orderNum){
        List<String> strings = orderService.selectOrderProcess(orderNum);
        return strings.toString();
    }

    @RequestMapping(path = "/deleteorder")
    @ResponseBody
    public String deleteOrder(@RequestParam(value = "orderNum") String orderNum){
        Map<String,String> map = new HashMap<>();
        try {
            map = orderService.deleteOrder(orderNum);
        } catch (Exception e) {
            logger.error("删除随工单异常" + e.getMessage());
            map.put("code","3");
        }
        return map.toString();
    }
}
