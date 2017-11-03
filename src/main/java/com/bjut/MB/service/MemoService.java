package com.bjut.MB.service;

import com.bjut.MB.model.Memo;
import com.bjut.MB.model.Order;
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
public class MemoService {
    private static final Logger logger = LoggerFactory.getLogger(MemoService.class);

    @Autowired
    //private MemoDao memoDao;

    public Map<String,String> addMemo(String orderNum,String name,String number,String boardNum,
                                      String weld,String debug,String test,String version,String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(name)){
            map.put("code","2");
            map.put("msg", "备忘录名称不能为空！");
            return map;
        }
        //int i = memoDao.addMemo(orderNum, name, number, boardNum, weld, debug, test, version, ps);
        //map.put("code",i);
        return map;
    }
    public Map<String, String> updateMemo(String orderNum,String name,String number,String boardNum,
                                          String weld,String debug,String test,String version,String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "随工单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(name)){
            map.put("code","2");
            map.put("msg", "备忘录名称不能为空！");
            return map;
        }
        //int i = memoDao.updateMemo(orderNum, name, number, boardNum, weld, debug, test, version, ps);
        //map.put("code",i);
        return map;
    }

    public List<Memo> selectMemo(String orderNum){
        //return memoDao.selectMemo(orderNum);
        return null;
    }
}
