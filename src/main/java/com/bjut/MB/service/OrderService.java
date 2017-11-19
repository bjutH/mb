package com.bjut.MB.service;

import com.bjut.MB.Utils.ExcelUtils;
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


    /**
     *
     * @param orderNum  产品编号
     * @param process   工序名称
     * @param path       文件路径
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> addOrder(String orderNum, String process, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "随工单工序名称不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","2");
            map.put("msg", "随工单路径不能为空！");
            return map;
        }
        try {
            orderDao.addItem(orderNum, process, path);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加随工单DAO异常" + e.getMessage());
            map.put("code","0");
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
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
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
            orderDao.updateItem(orderNum, operater, process, other, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新随工单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个LIST集合
     */
    public List<Order> selectOrder(String orderNum){
        return orderDao.selectAll(orderNum);
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
     * @return           返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteOrder(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        try {
            orderDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除随工单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
