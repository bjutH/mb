package com.bjut.MB.service;

import com.bjut.MB.dao.DebugDao;
import com.bjut.MB.model.Debug;
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
 * Created by Administrator on 2017/11/6.
 */
//整机调试报告单
@Service
public class DebugService {
    private static final Logger logger = LoggerFactory.getLogger(DebugService.class);

    @Autowired
    private DebugDao debugDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   理论数据
     * @param path      文件路径
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String,String> addDebug(String orderNum, String process,String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "整机调试报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "整机调试报告单要求不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","1");
            map.put("msg", "整机调试报告单路径不能为空！");
            return map;
        }
        try {
            debugDao.addItem(orderNum, process, path);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("添加整机调试报告单DAO异常" + e.getMessage());
            map.put("code","1");
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
     * @return  返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> updateDebug(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "整机调试报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "整机调试报告单要求不能为空！");
            return map;
        }
        try {
            debugDao.updateItem(orderNum, data, result, detectionDevice, deviceType, deviceNum, ps, process);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("更新整机调试报告单DAO异常" + e.getMessage());
            map.put("code","1");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个Debug的List集合
     */
    public List<Debug> selectDebug(String orderNum){
        return debugDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Debug的process的List集合
     */
    public List<String> selectDebugProcess(String orderNum){
        List<Debug> debugs = debugDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(Debug debug : debugs){
            String string = debug.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return debugDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   观测数据
     * @return           返回一个Debug对象
     */
    public Debug selectDebug(String orderNum, String process){
        return debugDao.selectOne(orderNum,process);
    }
    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> deleteDebug(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "整机调试报告单编号不能为空！");
            return map;
        }
        try {
            debugDao.deleteAll(orderNum);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("删除整机调试报告单DAO异常" + e.getMessage());
            map.put("code","1");
        }
        return map;
    }
}
