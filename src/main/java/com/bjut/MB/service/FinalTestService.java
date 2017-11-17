package com.bjut.MB.service;

import com.bjut.MB.dao.FinalTestDao;
import com.bjut.MB.model.FinalTest;
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
 * Created by Administrator on 2017/11/6.
 */
@Service
public class FinalTestService {
    private static final Logger logger = LoggerFactory.getLogger(FinalTestService.class);

    @Autowired
    private FinalTestDao finalTestDao;

    /**
     *
     * @param orderNum          仪器编号
     * @param process           名称
     * @param machineType       仪器型号
     * @param lable             内部标记
     * @param check             检验结果
     * @param checker           检验员
     * @param date              检验日期
     * @param finalChecker      核验人
     * @param finalDate         核验放行日期
     * @param result            确认数量、检验结果合格-不合格
     * @return                  返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addFinalTest(String orderNum, String process, String machineType, String lable, String check,
                                           String checker, Date date, String finalChecker, Date finalDate, String result){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "最终检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "最终检验报告单内容不能为空！");
            return map;
        }
        try {
            finalTestDao.addItem(orderNum, machineType, lable, check, checker, date, finalChecker, finalDate, process, result);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加最终检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum          仪器编号
     * @param process           名称
     * @param machineType       仪器型号
     * @param lable             内部标记
     * @param check             检验结果
     * @param checker           检验员
     * @param date              检验日期
     * @param finalChecker      核验人
     * @param finalDate         核验放行日期
     * @param result            确认数量、检验结果合格-不合格
     * @return                  返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateFinalTest(String orderNum, String process, String machineType, String lable, String check,
                                               String checker, Date date, String finalChecker, Date finalDate, String result){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "最终检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "最终检验报告单内容不能为空！");
            return map;
        }
        try {
            finalTestDao.updateItem(orderNum, machineType, lable, check, checker, date, finalChecker, finalDate, process, result);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新最终检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个LIST集合
     */
    public List<FinalTest> selectFinalTest(String orderNum){
        return finalTestDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   名称
     * @return          返回一个FinalTest对象
     */
    public FinalTest selectFinalTest(String orderNum, String process){
        return finalTestDao.selectItem(orderNum, process);
    }
    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteFinalTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "最终检验报告单编号不能为空！");
            return map;
        }
        try {
            finalTestDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除最终检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
