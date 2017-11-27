package com.bjut.MB.service;

import com.bjut.MB.dao.SphygmomanometerDao;
import com.bjut.MB.model.Sphygmomanometer;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/6.
 */
//血压计鉴定报告单
@Service
public class SphygmomanometerService {
    private static final Logger logger = LoggerFactory.getLogger(SphygmomanometerService.class);

    @Autowired
    private SphygmomanometerDao sphygmomanometerDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   序号
     * @param path      文件路径
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addSphygmomanometer(String orderNum, String process, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单内容不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单路径不能为空！");
            return map;
        }
        try{
            sphygmomanometerDao.addItem(orderNum, process, path);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加血压计检定报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   序号
     * @param data      实际数据
     * @param result    结论
     * @param ps        备注
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateSphygmomanometer(String orderNum, String process, String data, String result, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单内容不能为空！");
            return map;
        }
        try {
            sphygmomanometerDao.updateItem(orderNum, data, result, process, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新血压计检定报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Sphygmomanometer的List集合
     */
    public List<Sphygmomanometer> selectSphygmomanometer(String orderNum){
        return sphygmomanometerDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Sphygmomanometer的process的List集合
     */
    public List<String> selectSphygmomanometerProcess(String orderNum){
        List<Sphygmomanometer> sphygmomanometers = sphygmomanometerDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(Sphygmomanometer sphygmomanometer : sphygmomanometers){
            String string = sphygmomanometer.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   序号
     * @return          返回一个Sphygmomanometer对象
     */
    public Sphygmomanometer selectSphygmomanometer(String orderNum,String process){
        return sphygmomanometerDao.selectOne(orderNum, process);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return sphygmomanometerDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteSphygmomanometer(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "血压计检定报告单编号不能为空！");
            return map;
        }
        try {
            sphygmomanometerDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除血压计检定报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
