package com.bjut.MB.service;

import com.bjut.MB.dao.PerformTestDao;
import com.bjut.MB.model.PerformTest;
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
public class PerformTestService {
    private static final Logger logger = LoggerFactory.getLogger(PerformTestService.class);

    @Autowired
    private PerformTestDao performTestDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   序号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addPerformTest(String orderNum, String process){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "性能要求检验单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "性能要求检验单内容不能为空！");
            return map;
        }
        try {
            performTestDao.addItem(orderNum, process);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加性能要求检验单DAO异常" + e.getMessage());
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
    public Map<String, String> updatePerformTest(String orderNum, String process, String data, String result, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "性能要求检验单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "性能要求检验单内容不能为空！");
            return map;
        }
        try {
            performTestDao.updateItem(orderNum, process, data, result, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新性能要求检验单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个LIST集合
     */
    public List<PerformTest> selectPerformTest(String orderNum){
        return performTestDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deletePerformTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "性能要求检验单编号不能为空！");
            return map;
        }
        try {
            performTestDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除性能要求检验单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
