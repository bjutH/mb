package com.bjut.MB.service;

import com.bjut.MB.model.Pack;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 */
@Service
public class PackService {
    private static final Logger logger = LoggerFactory.getLogger(PackService.class);

    @Autowired
    //private PackDao packdao;

    public Map<String,String> addPack(String orderNum, String process, String result, String operater){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "装箱记录单名称不能为空！");
            return map;
        }
        //int i = packdao.addPack(orderNum, process, result, operater);
        //map.put("code",i);
        return map;
    }
    public Map<String, String> updatePack(String orderNum, String process, String result, String operater){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "装箱记录单名称不能为空！");
            return map;
        }
        //int i = packdao.updatePack(orderNum, process, result, operater);
        //map.put("code",i);
        return map;
    }

    public List<Pack> selectPack(String orderNum){
        //return aging.selectPack(orderNum);
        return null;
    }
}
