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
    private PackageListDao packageListDao;

    public Map<String,String> addPack(String orderNum, String process, String result, String operater){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "装箱记录单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "装箱记录单名称不能为空！");
            return map;
        }
        try {
            packageListDao.addProcess(orderNum, process, result, operater);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加装箱记录单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public Map<String, String> updatePack(String orderNum, String process, String result, String operater){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "装箱记录单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "装箱记录单名称不能为空！");
            return map;
        }
        try {
            packageListDao.UpdateConfirmAndPackager(orderNum, process, result, operater);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新装箱记录单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public List<Pack> selectPack(String orderNum){
        return packageListDao.selectConfirmAndPackager(orderNum);
    }

    public Map<String, String> deletePack(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        try {
            packageListDao.DeletePack(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除装箱记录单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
