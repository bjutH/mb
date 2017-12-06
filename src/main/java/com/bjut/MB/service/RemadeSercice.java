package com.bjut.MB.service;

import com.bjut.MB.dao.RemadeDao;
import com.bjut.MB.model.Remade;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/11/3.
 */
//返工记录表
@Service
public class RemadeSercice {
    private static final Logger logger = LoggerFactory.getLogger(RemadeSercice.class);

    @Autowired
    private RemadeDao remadeDao;

    /**
     *
     * @param orderNum  产品编号
     * @param date      日期
     * @param number    更改单号
     * @param updateSoftware    软件更改内容简述
     * @param updateHardware    硬件更改内容简述
     * @param updateContent     结构更改内容简述
     * @param updatePeople      更改人
     * @param testPeople        检查人
     * @param path              文件路径
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String,String> addRemade(String orderNum, Date date,String number,String updateSoftware,String updateHardware,
                                        String updateContent,String updatePeople,String testPeople, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "返工记录表编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(date.toString())){
            map.put("code","1");
            map.put("msg", "返工记录表时间不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","1");
            map.put("msg", "返工记录表路径不能为空！");
            return map;
        }
        try {
            remadeDao.addItem(orderNum, date, number, updateSoftware, updateHardware, updateContent, updatePeople, testPeople, path);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("添加返工记录表DAO异常" + e.getMessage());
            map.put("code","1");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param date      日期
     * @param number    更改单号
     * @param updateSoftware    软件更改内容简述
     * @param updateHardware    硬件更改内容简述
     * @param updateContent     结构更改内容简述
     * @param updatePeople      更改人
     * @param testPeople        检查人
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> updateRemade(String orderNum, Date date, String number, String updateSoftware, String updateHardware,
                                            String updateContent, String updatePeople, String testPeople){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "返工记录表编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(date.toString())){
            map.put("code","1");
            map.put("msg", "返工记录表时间不能为空！");
            return map;
        }
        try {
            remadeDao.updateItem(orderNum, date, number, updateSoftware, updateHardware, updateContent, updatePeople, testPeople);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("更新返工记录表DAO异常" + e.getMessage());
            map.put("code","1");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Remade的List集合
     */
    public List<Remade> selectRemade(String orderNum){
        return remadeDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return remadeDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> deleteRemade(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "返工记录表编号不能为空！");
            return map;
        }
        try {
            remadeDao.deleteAll(orderNum);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("删除返工记录表DAO异常" + e.getMessage());
            map.put("code","1");
        }
        return map;
    }
}
