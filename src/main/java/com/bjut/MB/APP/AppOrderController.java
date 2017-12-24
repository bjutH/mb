package com.bjut.MB.APP;

import com.bjut.MB.Utils.Base64Utils;
import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.model.Header;
import com.bjut.MB.model.Order;
import com.bjut.MB.service.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

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
    @Autowired
    private HeaderService headerService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private ExcelUtils excelUtils;

    @RequestMapping(value = "/order/selectall")
    public List<Order> selectAll(@RequestParam(value = "orderNum") String orderNum,HttpSession session) {
        List<Order> list = new LinkedList<>();
        List<Order> list1 = new LinkedList<>();
        List<String> listtask = new LinkedList<>();
        list = orderService.selectOrder(orderNum);
        String name = session.getAttribute("appname").toString();
        listtask = taskService.queryTask(name);

        for(Order order:list){
            String path = order.getOperater();
            if(!StringUtils.isBlank(path)) {
                String operater = Base64Utils.encode(path);
                order.setOperater(operater);
            }
            if(listtask.contains(order.getProcess())){
                list1.add(order);
            }
        }
        return list1;
    }

    @RequestMapping(value = "/order/selectone")
    public Order selectOne(@RequestParam(value = "orderNum") String orderNum,@RequestParam(value = "process") String process) {
        Order order = new Order();
        order = orderService.selectOrder(orderNum,process);
        String path = order.getOperater();
        if(!StringUtils.isBlank(path)) {
            String operater = Base64Utils.encode(path);
            order.setOperater(operater);
        }
        return order;
    }

    @RequestMapping(value = "/order/update")
    @Transactional
    public Map<String,String> select(@RequestParam(value = "orderNum") String orderNum, @RequestParam(value = "process") String process,
                                     @RequestParam(value = "operater") String operater, @RequestParam(value = "other") String other,
                                     @RequestParam(value = "ps") String ps, HttpServletRequest request) {
        Map<String,String> map = new HashMap<>();
        String name = UUID.randomUUID().toString();
        String jpgPath = request.getSession().getServletContext().getRealPath("/sign/" + name + ".jpg");
        if(Base64Utils.decodeJpg(operater,jpgPath)) {
            try {
                orderService.updateOrder(orderNum, process, jpgPath, other, ps);
                Order order = new Order();
                order.setOperater(jpgPath);
                order.setOther(other);
                order.setPs(ps);
                String path = orderService.selectPath(orderNum);
                excelUtils.replaceExcel(path,"随工单", process, order);
                map.put("code","0");
            }catch (Exception e){
                map.put("code","1");
                map.put("code","更新失败！");
            }
        }else {
            map.put("code","1");
            map.put("code","更新失败！");
        }
        return map;
    }

    @RequestMapping(value = "/order/updatehead")
    public Map<String,String> updateHead( @RequestParam(value = "excelType") String excelType,@RequestParam(value = "productNum") String productNum,
                                     @RequestParam(value = "productType") String productType,@RequestParam(value = "innerLabel") String innerLabel,
                                     @RequestParam(value = "productName") String productName) {
        Map<String,String> map = new HashMap<>();
        map = headerService.updateHeader(productNum,excelType,productName,productType,innerLabel,null,null,
                null,null,null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null,null,
                null,null);
        return map;
    }

    @RequestMapping(value = "/order/showhead")
    public Header selectHead( @RequestParam(value = "excelType") String excelType,@RequestParam(value = "productNum") String productNum) {
        Header header =headerService.selectHeader(productNum,excelType);
        return header;
    }
}
