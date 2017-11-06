package com.bjut.MB.service;

import com.bjut.MB.model.MachineTest;
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
public class MachineTestService {
    private static final Logger logger = LoggerFactory.getLogger(MachineTestService.class);

    @Autowired
    //private MachineTest machineTest;

    public Map<String,String> addMachineTest(String orderNum, String process, String data, String result, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "整机检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "整机检验报告单要求不能为空！");
            return map;
        }
        //int i = machineTest.addMachineTest(orderNum, process, data, result，ps);
        //map.put("code",i);
        return map;
    }
    public Map<String, String> updateMachineTest(String orderNum, String process, String data, String result, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "整机检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "整机检验报告单要求不能为空！");
            return map;
        }
        //int i = machineTest.updateMachineTest(orderNum, process, data, result，ps);
        //map.put("code",i);
        return map;
    }

    public List<MachineTest> selectMachineTest(String orderNum){
        //return machineTest.selectMachineTest(orderNum);
        return null;
    }
}
