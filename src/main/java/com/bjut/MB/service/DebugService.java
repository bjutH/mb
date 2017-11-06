package com.bjut.MB.service;

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
    //private DebugDao debugDao;

    public Map<String,String> addDebug(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
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
        //int i = debugDao.addDebug(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        //map.put("code",i);
        return map;
    }
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
        //int i = debugDao.updateDebug(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        //map.put("code",i);
        return map;
    }

    public List<Debug> selectDebug(String orderNum){
        //return debugDao.selectDebug(orderNum);
        return null;
    }
}
