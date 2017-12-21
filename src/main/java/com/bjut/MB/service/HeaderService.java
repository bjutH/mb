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
     * @param excel_type 表格类型
     * @param product_num 产品编号/仪器序号
     * @param product_name 产品名称
     * @param product_type 产品类型/仪器型号
     * @param inner_label 内部标记
     * @param debug_conclusion 调试结论
     * @param debuger 调试人员/检验员
     * @param debug_date 调试日期
     * @param environment_temperature 环境温度
     * @param relative_humidity 相对湿度
     * @param power 供电电源
     * @param is_groud 是否有效接地
     * @param check_machine_name1 检测设备名称
     * @param check_machine_type1 检测设备类型
     * @param check_machine_num1  检测设备编号
     * @param check_machine_name2 检测设备名称
     * @param check_machine_type2 检测设备类型
     * @param check_machine_num2  检测设备编号
     * @param check_machine_name3 检测设备名称
     * @param check_machine_type3 检测设备类型
     * @param check_machine_num3  检测设备编号
     * @param check_machine_name4 检测设备名称
     * @param check_machine_type4 检测设备类型
     * @param check_machine_num4  检测设备编号
     * @param check_machine_name5 检测设备名称
     * @param check_machine_type5 检测设备类型
     * @param check_machine_num5  检测设备编号
     * @param check_machine_name6 检测设备名称
     * @param check_machine_type6 检测设备类型
     * @param check_machine_num6  检测设备编号
     * @param check_machine_name7 检测设备名称
     * @param check_machine_type7 检测设备类型
     * @param check_machine_num7  检测设备编号
     * @param check_machine_name8 检测设备名称
     * @param check_machine_type8 检测设备类型
     * @param check_machine_num8  检测设备编号
     * @param check_machine_name9 检测设备名称
     * @param check_machine_type9 检测设备类型
     * @param check_machine_num9  检测设备编号
     * @param check_machine_name10 检测设备名称
     * @param check_machine_type10 检测设备类型
     * @param check_machine_num10  检测设备编号
     * @param check_machine_name11 检测设备名称
     * @param check_machine_type11 检测设备类型
     * @param check_machine_num11  检测设备编号
     * @param check_machine_name12 检测设备名称
     * @param check_machine_type12 检测设备类型
     * @param check_machine_num12  检测设备编号
     * @param checker 核验/放行人
     * @param check_date 核验/放行日期
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
        if(StringUtils.isBlank(product_num)){
            map.put("code","1");
            map.put("msg", "表头编号不能为空！");
            return map;
        }
        try {
            headerDao.updateItem(product_num, excel_type, product_name, product_type, inner_label, debug_conclusion, debuger,
                                  debug_date, environment_temperature, relative_humidity ,power, is_groud,
                                    check_machine_name1,check_machine_type1, check_machine_num1,
                                    check_machine_name2,check_machine_type2,check_machine_num2,
                                    check_machine_name3,check_machine_type3,check_machine_num3,
                                    check_machine_name4,check_machine_type4,check_machine_num4,
                                    check_machine_name5,check_machine_type5, check_machine_num5,
                                    check_machine_name6,check_machine_type6,check_machine_num6,
                                    check_machine_name7,check_machine_type7,check_machine_num7,
                                    check_machine_name8,check_machine_type8,check_machine_num8,
                                    check_machine_name9,check_machine_type9, check_machine_num9,
                                    check_machine_name10,check_machine_type10,check_machine_num10,
                                    check_machine_name11,check_machine_type11,check_machine_num11,
                                    check_machine_name12,check_machine_type12,check_machine_num12,
                                    checker, check_date);
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
