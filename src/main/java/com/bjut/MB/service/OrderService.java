package com.bjut.MB.service;

import com.bjut.MB.dao.OrderDao;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/31.
 */
@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
   private OrderDao orderDao;
    public Map<String, String> addOrder(String orderNum, String process) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "工序名称不能为空！");
            return map;
        }
        //orderDao.addOrder(orderNum, process);
        map.put("code","0");
        return map;
    }

    public Map<String, String> updateOrder(String orderNum,String process,String operater,String other,String ps) throws Exception{
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "工序名称不能为空！");
            return map;
        }
        //orderDao.addOrder(orderNum, process);
        map.put("code","0");
        return map;
    }

}
