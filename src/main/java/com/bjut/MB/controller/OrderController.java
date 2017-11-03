package com.bjut.MB.controller;

import com.bjut.MB.model.Order;
import com.bjut.MB.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/31.
 */
@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/addorder")
    @ResponseBody
    public String addOrder(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "processes") String processes){
        Map<String,String> map = new HashMap<>();
        try {
            map = orderService.addOrder(orderNum,processes);
        }
        catch (Exception e){
            logger.error("添加随工单异常" + e.getMessage());
            map.put("code","2");
        }
        return map.toString();
    }

    @RequestMapping(value = "/updateorder")
    @ResponseBody
    public String updateOrder(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "processes") String processes,
    @RequestParam(value = "operater") String operater,@RequestParam(value = "other") String other,@RequestParam(value = "ps") String ps){
        Map<String,String> map = new HashMap<>();
        try {
            map = orderService.updateOrder(orderNum,processes,operater,other,ps);
        } catch (Exception e) {
            logger.error("更新随工单异常" + e.getMessage());
            map.put("code","2");
        }
        return map.toString();
    }

    @RequestMapping(value = "/selectorder")
    public String selectOrder(Model model,String orderNum){
        List<Order> orderList = orderService.selectOrder(orderNum);
        return null;
    }
}
