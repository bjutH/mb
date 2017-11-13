package com.bjut.MB.service;

import com.bjut.MB.dao.PerformTestDao;
import com.bjut.MB.model.PerformTest;
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
public class PerformTestService {
    private static final Logger logger = LoggerFactory.getLogger(PerformTestService.class);

    @Autowired
    private PerformTestDao performTestDao;

    public Map<String,String> addPerformTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "性能要求检验单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "性能要求检验单内容不能为空！");
            return map;
        }
        try {
            performTestDao.addItem(orderNum, process);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加性能要求检验单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public Map<String, String> updatePerformTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "性能要求检验单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "性能要求检验单内容不能为空！");
            return map;
        }
        try {
            performTestDao.updateItem(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新性能要求检验单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public List<PerformTest> selectPerformTest(String orderNum){
        return performTestDao.selectAll(orderNum);
    }

    public Map<String, String> deletePerformTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        try {
            performTestDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除性能要求检验单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
