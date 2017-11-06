package com.bjut.MB.service;

import com.bjut.MB.model.FinalTest;
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
public class FinalTestService {
    private static final Logger logger = LoggerFactory.getLogger(FinalTestService.class);

    @Autowired
    //private FinalTestDao finalTestDao;

    public Map<String,String> addFinalTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "最终检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "最终检验报告单内容不能为空！");
            return map;
        }
        //int i = finalTestDao.addFinalTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        //map.put("code",i);
        return map;
    }
    public Map<String, String> updateFinalTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "最终检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "最终检验报告单内容不能为空！");
            return map;
        }
        //int i = finalTestDao.updateFinalTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        //map.put("code",i);
        return map;
    }

    public List<FinalTest> selectFinalTest(String orderNum){
        //return finalTestDao.selectFinalTest（orderNum);
        return null;
    }
}
