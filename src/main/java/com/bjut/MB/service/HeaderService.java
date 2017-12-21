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
     * @param productNum 产品编号/仪器序号
     * @param excelType 表格类型
     * @param productName 产品名称
     * @param productType 产品类型/仪器型号
     * @param innerLabel 内部标记
     * @param debugConclusion 调试结论
     * @param debuger 调试人员/检验员
     * @param debugDate 调试日期
     * @param environmentTemperature 环境温度
     * @param relativeHumidity 相对湿度
     * @param power 供电电源
     * @param isGroud 是否有效接地
     * @param checkMachineName1 检测设备名称
     * @param checkMachineType1 检测设备类型
     * @param checkMachineNum1  检测设备编号
     * @param checkMachineName2 检测设备名称
     * @param checkMachineType2 检测设备类型
     * @param checkMachineNum2  检测设备编号
     * @param checkMachineName3 检测设备名称
     * @param checkMachineType3 检测设备类型
     * @param checkMachineNum3  检测设备编号
     * @param checkMachineName4 检测设备名称
     * @param checkMachineType4 检测设备类型
     * @param checkMachineNum4  检测设备编号
     * @param checkMachineName5 检测设备名称
     * @param checkMachineType5 检测设备类型
     * @param checkMachineNum5  检测设备编号
     * @param checkMachineName6 检测设备名称
     * @param checkMachineType6 检测设备类型
     * @param checkMachineNum6  检测设备编号
     * @param checkMachineName7 检测设备名称
     * @param checkMachineType7 检测设备类型
     * @param checkMachineNum7  检测设备编号
     * @param checkMachineName8 检测设备名称
     * @param checkMachineType8 检测设备类型
     * @param checkMachineNum8  检测设备编号
     * @param checkMachineName9 检测设备名称
     * @param checkMachineType9 检测设备类型
     * @param checkMachineNum9  检测设备编号
     * @param checkMachineName10 检测设备名称
     * @param checkMachineType10 检测设备类型
     * @param checkMachineNum10  检测设备编号
     * @param checkMachineName11 检测设备名称
     * @param checkMachineType11 检测设备类型
     * @param checkMachineNum11  检测设备编号
     * @param checkMachineName12 检测设备名称
     * @param checkMachineType12 检测设备类型
     * @param checkMachineNum12  检测设备编号
     * @param checker 核验/放行人
     * @param checkDate 核验/放行日期
     * @return          返回一个map，key:code时，value为0则正常；为1说明有错
     */
    public Map<String, String> updateHeader(String productNum, String excelType, String productName, String productType,
                                            String innerLabel, String  debugConclusion, String debuger, Date debugDate,
                                            String environmentTemperature, String relativeHumidity, String power, String isGroud,
                                            String checkMachineName1, String checkMachineType1, String checkMachineNum1,
                                            String checkMachineName2, String checkMachineType2, String checkMachineNum2,
                                            String checkMachineName3, String checkMachineType3, String checkMachineNum3,
                                            String checkMachineName4, String checkMachineType4, String checkMachineNum4,
                                            String checkMachineName5, String checkMachineType5, String checkMachineNum5,
                                            String checkMachineName6, String checkMachineType6, String checkMachineNum6,
                                            String checkMachineName7, String checkMachineType7, String checkMachineNum7,
                                            String checkMachineName8, String checkMachineType8, String checkMachineNum8,
                                            String checkMachineName9, String checkMachineType9, String checkMachineNum9,
                                            String checkMachineName10, String checkMachineType10, String checkMachineNum10,
                                            String checkMachineName11, String checkMachineType11, String checkMachineNum11,
                                            String checkMachineName12, String checkMachineType12, String checkMachineNum12,
                                            String checker, Date checkDate){
        Map<String, String> map = new HashMap<String, String>();
        if(StringUtils.isBlank(productNum)){
            map.put("code","1");
            map.put("msg", "表头编号不能为空！");
            return map;
        }
        try {
            headerDao.updateItem(productNum, excelType, productName, productType, innerLabel, debugConclusion, debuger,
                                    debugDate, environmentTemperature, relativeHumidity ,power, isGroud,
                                    checkMachineName1,checkMachineType1, checkMachineNum1,
                                    checkMachineName2,checkMachineType2, checkMachineNum2,
                                    checkMachineName3,checkMachineType3, checkMachineNum3,
                                    checkMachineName4,checkMachineType4, checkMachineNum4,
                                    checkMachineName5,checkMachineType5, checkMachineNum5,
                                    checkMachineName6,checkMachineType6, checkMachineNum6,
                                    checkMachineName7,checkMachineType7, checkMachineNum7,
                                    checkMachineName8,checkMachineType8, checkMachineNum8,
                                    checkMachineName9,checkMachineType9, checkMachineNum9,
                                    checkMachineName10,checkMachineType10, checkMachineNum10,
                                    checkMachineName11,checkMachineType11, checkMachineNum11,
                                    checkMachineName12,checkMachineType12, checkMachineNum12,
                                    checker, checkDate);
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
    public List<Header> selectHeaderAll(String orderNum,String orderType){
        return headerDao.selectAll(orderNum,orderType);
    }

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
