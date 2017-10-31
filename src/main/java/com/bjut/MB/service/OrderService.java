package com.bjut.MB.service;

import com.bjut.MB.dao.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/31.
 */
@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
   private OrderDao orderDao;

    public int addOrder(String orderNum,String process) throws Exception{
        try {
            //orderDao.addOrder(orderNum, process);
            int i =1;
            return 0;
        }
        catch (Exception e){
            logger.error("添加随工单失败" + e.getMessage());
        }
        return 1;
    }
}
