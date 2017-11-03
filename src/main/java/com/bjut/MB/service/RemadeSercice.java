package com.bjut.MB.service;

import com.bjut.MB.model.Remade;
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
public class RemadeSercice {
    private static final Logger logger = LoggerFactory.getLogger(RemadeSercice.class);

    @Autowired
    //private RemadeDao remadeDao;

    public Map<String,String> addRemade(String orderNum, Date date,String number,String updateSoftware,String updateHardware,
                                        String updateContent,String updatePeople,String testPeople){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(date.toString())){
            map.put("code","2");
            map.put("msg", "返工记录表时间不能为空！");
            return map;
        }
        //int i = remadeDao.addRemade(orderNum, date, number, updateSoftware, updateHardware, updateContent, updatePeople, testPeople);
        //map.put("code",i);
        return map;
    }
    public Map<String, String> updateRemade(String orderNum, Date date, String number, String updateSoftware, String updateHardware,
                                            String updateContent, String updatePeople, String testPeople){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(date.toString())){
            map.put("code","2");
            map.put("msg", "返工记录表时间不能为空！");
            return map;
        }
        //int i = remadeDao.updateRemade(orderNum, date, number, updateSoftware, updateHardware, updateContent, updatePeople, testPeople);
        //map.put("code",i);
        return map;
    }

    public List<Remade> selectRemade(String orderNum){
        //return remadeDao.selectRemade(orderNum);
        return null;
    }
}
