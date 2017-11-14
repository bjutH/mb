package com.bjut.MB.service;

import com.bjut.MB.dao.RemadeDao;
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
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addRemade(String orderNum, Date date,String number,String updateSoftware,String updateHardware,
                                        String updateContent,String updatePeople,String testPeople){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "返工记录表编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(date.toString())){
            map.put("code","2");
            map.put("msg", "返工记录表时间不能为空！");
            return map;
        }
        try {
            remadeDao.addItem(orderNum, date, number, updateSoftware, updateHardware, updateContent, updatePeople, testPeople);
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
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateRemade(String orderNum, Date date, String number, String updateSoftware, String updateHardware,
                                            String updateContent, String updatePeople, String testPeople){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "返工记录表编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(date.toString())){
            map.put("code","2");
            map.put("msg", "返工记录表时间不能为空！");
            return map;
        }
        try {
            remadeDao.updateItem(orderNum, date, number, updateSoftware, updateHardware, updateContent, updatePeople, testPeople);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新返工记录表DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个LIST集合
     */
    public List<Remade> selectRemade(String orderNum){
        return remadeDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteRemade(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "返工记录表编号不能为空！");
            return map;
        }
        try {
            remadeDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除返工记录表DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
