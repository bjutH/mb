package com.bjut.MB.service;

import com.bjut.MB.model.Sphygmomanometer;
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
public class SphygmomanometerService {
    private static final Logger logger = LoggerFactory.getLogger(SphygmomanometerService.class);

    @Autowired
    private SphygmomanometerDao sphygmomanometerDao;

    public Map<String,String> addSphygmomanometer(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单内容不能为空！");
            return map;
        }
        try{
            sphygmomanometerDao.addSphygmomanometer(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加血压计检定报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public Map<String, String> updateSphygmomanometer(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单内容不能为空！");
            return map;
        }
        try {
            sphygmomanometerDao.updateSphygmomanometer(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新血压计检定报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public List<Sphygmomanometer> selectSphygmomanometer(String orderNum){
        return sphygmomanometerDao.selectSphygmomanometer(orderNum);
    }

    public Map<String, String> deleteSphygmomanometer(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        try {
            sphygmomanometerDao.deleteSphygmomanometer(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除血压计检定报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
