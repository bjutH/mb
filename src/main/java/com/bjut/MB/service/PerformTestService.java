package com.bjut.MB.service;

import com.bjut.MB.dao.PerformTestDao;
import com.bjut.MB.model.PerformTest;
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
//性能要求检验单
@Service
public class PerformTestService {
    private static final Logger logger = LoggerFactory.getLogger(PerformTestService.class);

    @Autowired
    private PerformTestDao performTestDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   序号
     * @param path      文件路径
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String,String> addPerformTest(String orderNum, String process, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "性能要求检验单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "性能要求检验单内容不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","1");
            map.put("msg", "性能要求检验单路径不能为空！");
            return map;
        }
        try {
            performTestDao.addItem(orderNum, process, path);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("添加性能要求检验单DAO异常" + e.getMessage());
            map.put("code","1");
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
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> updatePerformTest(String orderNum, String process, String data, String result, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "性能要求检验单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "性能要求检验单内容不能为空！");
            return map;
        }
        try {
            performTestDao.updateItem(orderNum, process, data, result, ps);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("更新性能要求检验单DAO异常" + e.getMessage());
            map.put("code","1");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个PerformTest的List集合
     */
    public List<PerformTest> selectPerformTest(String orderNum){
        return performTestDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个PerformTest的process的List集合
     */
    public List<String> selectPerformTestProcess(String orderNum){
        List<PerformTest> performTests = performTestDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(PerformTest performTest : performTests){
            String string = performTest.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   序号
     * @return           返回一个PerformTest对象
     */
    public PerformTest selectPerformTest(String orderNum, String process){
        return performTestDao.selectOne(orderNum, process);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return performTestDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> deletePerformTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "性能要求检验单编号不能为空！");
            return map;
        }
        try {
            performTestDao.deleteAll(orderNum);
            map.put("code","0");
        }
        catch (Exception e){
            logger.error("删除性能要求检验单DAO异常" + e.getMessage());
            map.put("code","1");
        }
        return map;
    }
}
