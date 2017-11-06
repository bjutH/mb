package com.bjut.MB.service;

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
    //private ProcessesTestDao processesTestDao;

    public Map<String,String> addProcessesTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
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
        //int i = processesTestDao.addProcessesTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        //map.put("code",i);
        return map;
    }
    public Map<String, String> updateProcessesTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
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
        //int i = processesTestDao.updateProcessesTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
        //map.put("code",i);
        return map;
    }

    public List<ProcessTest> selectProcessesTest(String orderNum){
        //return processesTestDao.selectProcessesTest（orderNum);
        return null;
    }
}
