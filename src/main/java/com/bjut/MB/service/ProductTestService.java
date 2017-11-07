package com.bjut.MB.service;

import com.bjut.MB.model.ProductTest;
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
public class ProductTestService {
    private static final Logger logger = LoggerFactory.getLogger(ProductTestService.class);

    @Autowired
    private ProductTestDao productTestDao;

    public Map<String,String> addProductTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "成品检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "成品检验报告单要求不能为空！");
            return map;
        }
        try {
            productTestDao.addProductTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加成品检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public Map<String, String> updateProductTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "成品检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "成品检验报告单要求不能为空！");
            return map;
        }
        try {
            productTestDao.updateProductTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新成品检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public List<ProductTest> selectProductTest(String orderNum){
        return productTestDao.selectProductTest(orderNum);
    }

    public Map<String, String> deleteProductTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        try {
            productTestDao.deleteProductTest(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除成品检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
