package com.bjut.MB.service;

import com.bjut.MB.dao.FinalTestDao;
import com.bjut.MB.model.FinalTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Administrator on 2017/11/6.
 */
//最终检验报告单
@Service
public class FinalTestService {
    private static final Logger logger = LoggerFactory.getLogger(FinalTestService.class);

    @Autowired
    private FinalTestDao finalTestDao;

    /**
     *
     * @param orderNum          仪器编号
     * @param process           名称
     * @param path              文件路径
     * @return                  返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String,String> addFinalTest(String orderNum, String process, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "最终检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "最终检验报告单内容不能为空！");
            return map;
        }
        try {
            finalTestDao.addItem(orderNum, process, path);
            map.put("code","0");
            map.put("msg", "添加最终检验报告单成功！");
        }
        catch (Exception e){
            logger.error("添加最终检验报告单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "添加最终检验报告单异常！");
        }
        return map;
    }

    /**
     *
     * @param orderNum          仪器编号
     * @param process           名称
     * @param result            确认数量、检验结果合格-不合格
     * @return                  返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> updateFinalTest(String orderNum, String process, String result){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "最终检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "最终检验报告单内容不能为空！");
            return map;
        }
        try {
            finalTestDao.updateItem(orderNum, process, result);
            map.put("code","0");
            map.put("msg", "更新最终检验报告单成功！");
        }
        catch (Exception e){
            logger.error("更新最终检验报告单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "更新最终检验报告单异常！");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个FinalTest的List集合
     */
    public List<FinalTest> selectFinalTest(String orderNum){
        return finalTestDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个FinalTest的process的List集合
     */
    public List<String> selectFinalTestProcess(String orderNum){
        List<FinalTest> finalTests = finalTestDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(FinalTest finalTest : finalTests){
            String string = finalTest.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return finalTestDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   名称
     * @return          返回一个FinalTest对象
     */
    public FinalTest selectFinalTest(String orderNum, String process){
        return finalTestDao.selectOne(orderNum, process);
    }
    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> deleteFinalTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "最终检验报告单编号不能为空！");
            return map;
        }
        try {
            finalTestDao.deleteAll(orderNum);
            map.put("code","0");
            map.put("msg", "删除最终检验报告单成功！");
        }
        catch (Exception e){
            logger.error("删除最终检验报告单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "删除最终检验报告单异常！");
        }
        return map;
    }
}
