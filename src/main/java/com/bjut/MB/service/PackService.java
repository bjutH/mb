package com.bjut.MB.service;

import com.bjut.MB.dao.PackDao;
import com.bjut.MB.model.Pack;
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
 * Created by Administrator on 2017/11/3.
 */
//装箱记录单
@Service
public class PackService {
    private static final Logger logger = LoggerFactory.getLogger(PackService.class);

    @Autowired
    private PackDao packDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   名称
     * @param path       文件路径
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addPack(String orderNum, String process, String path){
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
        if(StringUtils.isBlank(path)){
            map.put("code","2");
            map.put("msg", "装箱记录单路径不能为空！");
            return map;
        }
        try {
            packDao.addItem(orderNum, process, path);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加装箱记录单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   名称
     * @param check     确认
     * @param result    自检项目
     * @param operater  包装人
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updatePack(String orderNum,String process, String check, String result, String operater){
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
            packDao.updateItem(check, result, operater, orderNum, process);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新装箱记录单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Pack的List集合
     */
    public List<Pack> selectPack(String orderNum){
        return packDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Pack的process的List集合
     */
    public List<String> selectPackProcess(String orderNum){
        List<Pack> packs = packDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(Pack pack : packs){
            String string = pack.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   名称
     * @return           返回一个Pack对象
     */
    public Pack selectPack(String orderNum, String process){
        return packDao.selectOne(orderNum, process);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return packDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deletePack(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "装箱记录单编号不能为空！");
            return map;
        }
        try {
            packDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除装箱记录单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
