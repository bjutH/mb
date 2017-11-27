package com.bjut.MB.service;

import com.bjut.MB.dao.ProductTestDao;
import com.bjut.MB.model.ProductTest;
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
//成品检验报告单
@Service
public class ProductTestService {
    private static final Logger logger = LoggerFactory.getLogger(ProductTestService.class);

    @Autowired
    private ProductTestDao productTestDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   检测项目
     * @param path       文件路径
     * @return           返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String,String> addProductTest(String orderNum, String process, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "成品检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "成品检验报告单要求不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","2");
            map.put("msg", "成品检验报告单路径不能为空！");
            return map;
        }
        try {
            productTestDao.addItem(orderNum, process, path);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("添加成品检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   检验项目
     * @param data      实测记录
     * @param result    单项结论
     * @param ps         备注
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> updateProductTest(String orderNum, String process, String data, String result, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "成品检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","2");
            map.put("msg", "成品检验报告单要求不能为空！");
            return map;
        }
        try {
            productTestDao.updateItem(orderNum, process, data, result, ps);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("更新成品检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个ProductTest的List集合
     */
    public List<ProductTest> selectProductTest(String orderNum){
        return productTestDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个ProductTest的process的List集合
     */
    public List<String> selectProductTestProcess(String orderNum){
        List<ProductTest> productTests = productTestDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(ProductTest productTest : productTests){
            String string = productTest.getProcess();
            processes.add(string);
        }
        return processes;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   检验项目
     * @return          返回一个ProductTest对象
     */
    public ProductTest selectProductTest(String orderNum, String process){
        return productTestDao.selectOne(orderNum, process);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return productTestDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个map，key:code时，value为1则正常；为2说明参数有错，并把信息放到msg的key里；为0说明数据库操作出错
     */
    public Map<String, String> deleteProductTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","2");
            map.put("msg", "成品检验报告单编号不能为空！");
            return map;
        }
        try {
            productTestDao.deleteAll(orderNum);
            map.put("code","1");
        }
        catch (Exception e){
            logger.error("删除成品检验报告单DAO异常" + e.getMessage());
            map.put("code","0");
        }
        return map;
    }
}
