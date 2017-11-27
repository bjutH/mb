package com.bjut.MB.service;

import com.bjut.MB.dao.ProcessTestDao;
import com.bjut.MB.model.ProcessTest;
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
//工序检验报告单
@Service
public class ProcessTestService {
    private static final Logger logger = LoggerFactory.getLogger(ProcessTestService.class);

    @Autowired
    private ProcessTestDao processTestDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   理论数据
     * @param path      文件路径
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addProcessTest(String orderNum, String process, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单要求不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单路径不能为空！");
            return map;
        }
        try {
            processTestDao.addItem(orderNum, process, path);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加关键工序检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   理论数据
     * @param data      检验数据
     * @param result    检验结果
     * @param detectionDevice   检验设备
     * @param deviceType    设备类型
     * @param deviceNum 设备编号
     * @param ps        备注
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateProcessTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单要求不能为空！");
            return map;
        }
        try {
            processTestDao.updateItem(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新关键工序检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回一个ProcessTest的List集合
     */
    public List<ProcessTest> selectProcessTest(String orderNum){
        return processTestDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个ProcessTest的process的List集合
     */
    public List<String> selectProcessTestProcess(String orderNum){
        List<ProcessTest> processTests = processTestDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(ProcessTest processTest : processTests){
            String string = processTest.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   理论数据
     * @return          返回一个ProcessTest对象
     */
    public ProcessTest selectProcessTest(String orderNum, String process){
        return processTestDao.selectOne(orderNum, process);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return processTestDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteProcessTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "关键工序检验报告单编号不能为空！");
            return map;
        }
        try {
            processTestDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除关键工序检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
