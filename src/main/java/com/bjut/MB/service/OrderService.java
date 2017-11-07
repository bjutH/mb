package com.bjut.MB.service;

import com.bjut.MB.dao.OrderDao;
import com.bjut.MB.model.Order;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/31.
 */
@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
   private OrderDao orderDao;

    public Map<String, String> addOrder(String orderNum,String process,String operater,String other,String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "工序名称不能为空！");
            return map;
        }
        try {
            orderDao.addProcess(orderNum, process);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加随工单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public Map<String, String> updateOrder(String orderNum,String process,String operater,String other,String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "工序名称不能为空！");
            return map;
        }
        try {
            orderDao.updateOperaterAndOther(orderNum, process, operater, other, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新随工单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public List<Order> selectOrder(String orderNum){
        return orderDao.selectOperaterAndOhter(orderNum);
    }

    public Map<String, String> deleteOrder(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        try {
            orderDao.deleteOrder(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除随工单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
