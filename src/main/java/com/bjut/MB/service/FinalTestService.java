package com.bjut.MB.service;

import com.bjut.MB.model.FinalTest;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
     * @param orderNum  产品编号
     * @param process   要求
     * @return  返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addFinalTest(String orderNum, String process){
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
            finalTestDao.addFinalTest(orderNum, process);
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
     * @param orderNum  产品编号
     * @param process   要求
     * @param data      数据
     * @param result    结果
     * @param detectionDevice   检测设备
     * @param deviceType    设备类型
     * @param deviceNum     设备编号
     * @param ps        备注
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateFinalTest(String orderNum, String process, String data, String result, String detectionDevice, String deviceType, String deviceNum, String ps){
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
            finalTestDao.updateFinalTest(orderNum, process, data, result, detectionDevice, deviceType, deviceNum, ps);
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
        return finalTestDao.selectFinalTest(orderNum);
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
            finalTestDao.deleteFinalTest(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除最终检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
