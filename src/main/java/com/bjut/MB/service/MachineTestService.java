package com.bjut.MB.service;

import com.bjut.MB.dao.MachineTestDao;
import com.bjut.MB.model.MachineTest;
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
//整机检验报告单
@Service
public class MachineTestService {
    private static final Logger logger = LoggerFactory.getLogger(MachineTestService.class);

    @Autowired
    private MachineTestDao machineTestDao;

    /**
     *
     * @param orderNum  产品编号
     * @param process   检测要求
     * @param path       文件路径
     * @return  返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String,String> addMachineTest(String orderNum, String process,String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "整机检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "整机检验报告单要求不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","1");
            map.put("msg", "整机检验报告单路径不能为空！");
            return map;
        }
        try {
            machineTestDao.addItem(orderNum, process, path);
            map.put("code","0");
            map.put("msg", "添加整机检验报告单成功！");
        }
        catch (Exception e){
            logger.error("添加整机检验报告单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "添加整机检验报告单异常！");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   检测要求
     * @param data      检验数据
     * @param result    检验结果
     * @param ps        备注
     * @return
     */
    public Map<String, String> updateMachineTest(String orderNum, String process, String data, String result, String ps){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "整机检验报告单编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(process)){
            map.put("code","1");
            map.put("msg", "整机检验报告单要求不能为空！");
            return map;
        }
        try {
            machineTestDao.updateItem(orderNum, data, result, process, ps);
            map.put("code","0");
            map.put("msg", "更新整机检验报告单成功！");
        }catch (Exception e){
            logger.error("更新整机检验报告单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "更新整机检验报告单异常！");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个MachineTest的List集合
     */
    public List<MachineTest> selectMachineTest(String orderNum){
        return machineTestDao.selectAll(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个MachineTest的process的List集合
     */
    public List<String> selectMachineTestProcess(String orderNum){
        List<MachineTest> machineTests = machineTestDao.selectAll(orderNum);
        List<String> processes = new ArrayList<String>();
        for(MachineTest machineTest : machineTests){
            String string = machineTest.getProcess();
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
        return machineTestDao.selectPath(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @param process   检测要求
     * @return          返回一个MachineTest对象
     */
    public MachineTest selectMachineTest(String orderNum, String process){
        return machineTestDao.selectOne(orderNum, process);
    }
    /**
     *
     * @param orderNum  产品编号
     * @return  返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> deleteMachineTest(String orderNum){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "整机检验报告单编号不能为空！");
            return map;
        }
        try {
            machineTestDao.deleteAll(orderNum);
            map.put("code","0");
            map.put("msg", "删除整机检验报告单成功！");
        }
        catch (Exception e){
            logger.error("删除整机检验报告单DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "删除整机检验报告单异常！");
        }
        return map;
    }
}
