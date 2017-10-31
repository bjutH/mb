package com.bjut.MB.controller;

import com.bjut.MB.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/10/31.
 */
@Controller
public class Order {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderService orderService;
    @RequestMapping(value = "/addorder")
    @ResponseBody
    public String addorder(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "processes") String processes){
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("code",0);
        try {
            int i = orderService.addOrder(orderNum,processes);
            hashMap.put("code",i);
            return hashMap.toString();
        } catch (Exception e) {
            logger.error("添加随工单失败" + e.getMessage());
            e.printStackTrace();
        }
        return hashMap.toString();
    }
}
