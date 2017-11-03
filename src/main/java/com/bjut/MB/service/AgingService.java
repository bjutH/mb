package com.bjut.MB.service;

import com.bjut.MB.model.Aging;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/3.
 */
@Service
public class AgingService {
    private static final Logger logger = LoggerFactory.getLogger(AgingService.class);

    @Autowired
    //private AgingDao agingDao;

    public Map<String,String> addAging(String orderNum, String process, String result, Date date, String phenomenon, String handle,String ps, String operater){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "老化观测表要求不能为空！");
            return map;
        }
        //int i = agingDao.addAging(orderNum, process, result, date, phenomenon, handle, ps, operater);
        //map.put("code",i);
        return map;
    }
    public Map<String, String> updateAging(String orderNum, String process, String result, Date date, String phenomenon, String handle,String ps, String operater){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "老化观测表要求不能为空！");
            return map;
        }
        //int i = agingDao.updateAging(orderNum, process, result, date, phenomenon, handle, ps, operater);
        //map.put("code",i);
        return map;
    }

    public List<Aging> selectAging(String orderNum){
        //return agingDao.selectAging(orderNum);
        return null;
    }
}
