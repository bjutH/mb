package com.bjut.MB.service;

import com.bjut.MB.dao.YiqiDao;
import com.bjut.MB.model.Memo;
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
    private YiqiDao yiqiDao;

    public Map<String,String> addMemo(String orderNum,String name,String number,String boardNum,
                                      String weld,String debug,String test,String version,String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "备忘录编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(name)){
            map.put("code","2");
            map.put("msg", "备忘录名称不能为空！");
            return map;
        }
        try {
            yiqiDao.addItem(orderNum, name);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加备忘录DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public Map<String, String> updateMemo(String orderNum,String name,String number,String boardNum,
                                          String weld,String debug,String test,String version,String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "备忘录编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(name)){
            map.put("code","2");
            map.put("msg", "备忘录名称不能为空！");
            return map;
        }
        try {
            yiqiDao.updateItem(orderNum, name, number, boardNum, weld, debug, test, version, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新备忘录DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    public List<Memo> selectMemo(String orderNum){
        return yiqiDao.selectAll(orderNum);
    }

    public Map<String, String> deleteMemo(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        try {
            yiqiDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除备忘录DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
