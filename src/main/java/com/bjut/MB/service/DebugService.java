package com.bjut.MB.service;

import com.bjut.MB.dao.DebugDao;
import com.bjut.MB.model.Debug;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */
@Service
public class DebugService {
    private static final Logger logger = LoggerFactory.getLogger(DebugService.class);

    @Autowired
    private DebugDao debugDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   理论数据
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addDebug(String orderNum, String process){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "整机调试报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "整机调试报告单要求不能为空！");
            return map;
        }
        try {
            debugDao.addItem(orderNum, process);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加整机调试报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   观测数据
     * @param data      理论数据
     * @param result    观测结果
     * @param detectionDevice   检测设备
     * @param deviceType    设备型号
     * @param deviceNum 设备编号
     * @param ps    备注
     * @return  返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateDebug(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "整机调试报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "整机调试报告单要求不能为空！");
            return map;
        }
        try {
            debugDao.updateItem(orderNum, data, result, detectionDevice, deviceType, deviceNum, ps, process);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新整机调试报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个LIST集合
     */
    public List<Debug> selectDebug(String orderNum){
        return debugDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   观测数据
     * @return           返回一个Debug对象
     */
    public Debug selectDebug(String orderNum, String process){
        return debugDao.selectItem(orderNum,process);
    }
    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteDebug(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "整机调试报告单编号不能为空！");
            return map;
        }
        try {
            debugDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除整机调试报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
