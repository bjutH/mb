package com.bjut.MB.service;

import com.bjut.MB.dao.HeaderDao;
import com.bjut.MB.model.Header;
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
 * Created by Administrator on 2017/11/19.
 */
//表头
@Service
public class HeaderService {
    private static final Logger logger = LoggerFactory.getLogger(AgingService.class);

    @Autowired
    private HeaderDao headerDao;

    /**
     *
     * @param orderNum  随工单编号
     * @param path      文件路径
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String,String> addHeader(String orderNum, String path){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "表头编号不能为空！");
            return map;
        }
        if(StringUtils.isBlank(path)){
            map.put("code","1");
            map.put("msg", "表头路径不能为空！");
            return map;
        }
        try {
            headerDao.addItem(orderNum, path);
            map.put("code","0");
            map.put("msg", "添加表头成功！");
        }
        catch (Exception e){
            logger.error("添加表DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "添加表异常！");
        }
        return map;
    }

    /**
     *
 * @param orderNum               产品编号/仪器序号
     * @param name                  产品名称
     * @param type                  产品类型/仪器型号
     * @param label                 内部标记
     * @param conclusion            调试结论
     * @param debuger               调试人员/检验员
     * @param date                  调试日期
     * @param temperature           环境温度
     * @param humidity              相对湿度
     * @param power                 供电电源
     * @param groud                 是否有效接地
     * @param checkMachineName      检测设备名称
     * @param checkMachineType      检测设备类型
     * @param checkMachineNum       检测设备编号
     * @param checker               核验/放行人
     * @param checkerDate           核验/放行日期
     * @return                      返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> updateHeader(String orderNum, String name, String type, String label, String conclusion,String debuger,
                                            Date date, String temperature, String humidity, String power, String groud ,String checkMachineName,
                                            String checkMachineType,String checkMachineNum, String checker, Date checkerDate){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(orderNum)){
            map.put("code","1");
            map.put("msg", "表头编号不能为空！");
            return map;
        }
        try {
//            headerDao.updateItem(orderNum, name, type, label, conclusion, debuger, date, temperature, humidity,
//                                power, groud ,checkMachineName, checkMachineType, checkMachineNum, checker, checkerDate);
            map.put("code","0");
            map.put("msg", "更新表头成功！");
        }
        catch (Exception e){
            logger.error("更新表头DAO异常" + e.getMessage());
            map.put("code","1");
            map.put("msg", "更新表头异常！");
        }
        return map;
    }

    /**
     *
     * @param orderNum  产品编号
     * @return          返回一个Header的LIST集合
     */
//    public List<Header> selectHeaderAll(String orderNum){
//        return headerDao.selectAll(orderNum);
//    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回一个Header对象
     */
    public Header selectHeader(String orderNum){
        return headerDao.selectOne(orderNum);
    }

    /**
     *
     * @param orderNum  产品编号
     * @return           返回地址
     */
    public String selectPath(String orderNum){
        return headerDao.selectPath(orderNum);
    }
}
