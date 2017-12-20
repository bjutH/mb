package com.bjut.MB.APP;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.HostHolder;
import com.bjut.MB.model.Order;
import com.bjut.MB.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

/**
 * Created by Administrator on 2017/12/20.
 */
@RestController
@RequestMapping(value = "/app")
public class AppOrderController {
    private static final Logger logger = LoggerFactory.getLogger(AppOrderController.class);

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order/select")
    public List<Order> select(@RequestParam(value = "orderNum") String orderNum) {
        List<Order> list = new LinkedList<>();
        list = orderService.selectOrder(orderNum);
        return list;
    }

    @RequestMapping(value = "/order/update")
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process,
                              @RequestParam(value = "operater") String operater,@RequestParam(value = "other") String other,
                              @RequestParam(value = "ps") String ps) {
        Map<String,String> map = new HashMap<>();
        map = orderService.updateOrder(orderNum,process,operater,other,ps);
        return map;
    }
}
