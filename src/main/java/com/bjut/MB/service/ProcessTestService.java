package com.bjut.MB.service;

import com.bjut.MB.dao.ProcessTestDao;
import com.bjut.MB.model.ProcessTest;
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
public class ProcessTestService {
    private static final Logger logger = LoggerFactory.getLogger(ProcessTestService.class);

    @Autowired
    private ProcessTestDao processTestDao;

    public Map<String,String> addProcessTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单要求不能为空！");
            return map;
        }
        try {
            processTestDao.addItem(orderNum, process);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加关键工序检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public Map<String, String> updateProcessTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单要求不能为空！");
            return map;
        }
        try {
            processTestDao.updateItem(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新关键工序检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public List<ProcessTest> selectProcessTest(String orderNum){
        return processTestDao.selectAll(orderNum);
    }

    public Map<String, String> deleteProcessTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        try {
            processTestDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除关键工序检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
