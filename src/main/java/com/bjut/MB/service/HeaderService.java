package com.bjut.MB.service;

import com.bjut.MB.dao.HeaderDao;
import com.bjut.MB.model.Header;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/19.
 */
@Service
public class HeaderService {
    private static final Logger logger = LoggerFactory.getLogger(AgingService.class);

    @Autowired
    private HeaderDao headerDao;

    /**
     *
     * @param orderNum  随工单编号
     * @param path      文件路径
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addHeader(String orderNum, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "表头编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","2");
            map.put("msg", "表头路径不能为空！");
            return map;
        }
        try {
            headerDao.addItem(orderNum, path);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加老化观测表DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
    public Map<String, String> updateHeader(String orderNum, String name, String type,String label, String conclusion,String debuger,
                                            Date date, String temperature, String humidity, String power, String groud){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "老化观测表编号不能为空！");
            return map;
        }
        try {
            headerDao.updateItem(orderNum, name, type, label, conclusion, debuger, date, temperature, humidity, power, groud);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新老化观测表DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个LIST集合
     */
    public List<Header> selectHeaderAll(String orderNum){
        return headerDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回一个Aging对象
     */
    public Header selectHeader(String orderNum){
        return headerDao.selectOne(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return headerDao.selectPath(orderNum);
    }
}
