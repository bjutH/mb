package com.bjut.MB.service;

import com.bjut.MB.dao.AgingDao;
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
    private AgingDao agingDao;

    /**
     *
     * @param orderNum 产品编号
     * @param process   要求
     * @param path      文件路径
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addAging(String orderNum, String process,String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "老化观测表编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "老化观测表要求不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","2");
            map.put("msg", "老化观测表路径不能为空！");
            return map;
        }
        try {
            agingDao.addItem(orderNum, process, path);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加老化观测表DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   要求
     * @param result    观测结果
     * @param date      观测时间
     * @param phenomenon    故障现象
     * @param handle    处理结果
     * @param ps        备注
     * @param operater  调试员
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateAging(String orderNum, String process, String result, Date date, String phenomenon, String handle,String ps, String operater){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "老化观测表编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "老化观测表要求不能为空！");
            return map;
        }
        try {
            agingDao.updateItem(orderNum, process, result, date, phenomenon, handle, ps, operater);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新老化观测表DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个LIST集合
     */
    public List<Aging> selectAging(String orderNum){
        return agingDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   要求
     * @return           返回一个Aging对象
     */
    public Aging selectAging(String orderNum, String process){
        return agingDao.selectOne(orderNum, process);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return agingDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteAging(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "老化观测表编号不能为空！");
            return map;
        }
        try {
            agingDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除老化观测表DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
