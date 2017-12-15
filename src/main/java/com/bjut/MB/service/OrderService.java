package com.bjut.MB.service;

import com.bjut.MB.Utils.ExcelUtils;
import com.bjut.MB.dao.OrderDao;
import com.bjut.MB.model.Order;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/31.
 */
//随工单表
@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
   private OrderDao orderDao;


    /**
     *
     * @param orderNum  产品编号
     * @param process   工序名称
     * @param path       文件路径
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> addOrder(String orderNum, String process, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "随工单工序名称不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","1");
            map.put("msg", "随工单路径不能为空！");
            return map;
        }
        try {
            orderDao.addItem(orderNum, process, path);
            map.put("code","0");
            map.put("msg", "添加随工单成功！");
        }
        catch (Exception e){
            logger.error("添加随工单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "添加随工单异常！");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   工序名称
     * @param operater  操作者
     * @param other     其他内容说明
     * @param ps        备注
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> updateOrder(String orderNum,String process,String operater,String other,String ps){
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
        try {
            orderDao.updateItem(orderNum, operater, process, other, ps);
            map.put("code","0");
            map.put("msg", "更新随工单成功！");
        }
        catch (Exception e){
            logger.error("更新随工单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "更新随工单异常！");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Order的LIST集合
     */
    public List<Order> selectOrder(String orderNum){
        return orderDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Order的process的LIST集合
     */
    public List<String> selectOrderProcess(String orderNum){
        List<Order> orders = orderDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(Order order : orders){
            String string = order.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   工序名称
     * @return          返回一个Order对象
     */
    public Order selectOrder(String orderNum, String process){
        return orderDao.selectOne(orderNum, process);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return orderDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> deleteOrder(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        List<Order> orders = orderDao.selectAll(orderNum);
        if(orders.size() ==0){
            map.put("code","1");
            map.put("msg","随工单编号不存在！");
            return map;
        }
        try {
            orderDao.deleteAll(orderNum);
            map.put("code","0");
            map.put("msg", "删除随工单成功！");
        }
        catch (Exception e){
            logger.error("删除随工单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "删除随工单异常！");
        }
        return map;
    }
}
