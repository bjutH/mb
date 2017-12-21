package com.bjut.MB.dao;

import com.bjut.MB.model.FinalTest;
import com.bjut.MB.model.Header;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/11/19.
 */
@Mapper
public interface HeaderDao {
    String TABLE_NAME = "header";
    String INSERT_FIELDS = "'product_num', 'path'";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{path})"})
    void addItem(@Param("product_num") String product_num, @Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and excel_type = #{excel_type}"})
    List<Header> selectAll(@Param("product_num") String product_num, @Param("excel_type") String excel_type);

    /**
     *
     * @param product_num 产品编号
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    Header selectOne(@Param("product_num") String product_num);


    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);
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
     */
    @Update({"update ", TABLE_NAME, "set product_name = #{product_name}, product_type = #{product_type}, inner_label = #{inner_label}, debug_conclusion = #{debug_conclusion}, debuger = #{debuger}, debug_date = #{debug_date}, environment_temperature = #{environment_temperature}, relative_humidity = #{relative_humidity}, power = #{power}, is_groud = #{is_groud}, " +
            "check_machine_name1 = #{check_machine_name1}, check_machine_type1 = #{check_machine_type1}, check_machine_num1 = #{check_machine_num1}, " +
            "check_machine_name2 = #{check_machine_name2}, check_machine_type2 = #{check_machine_type2}, check_machine_num2 = #{check_machine_num2}, " +
            "check_machine_name3 = #{check_machine_name3}, check_machine_type3 = #{check_machine_type3}, check_machine_num3 = #{check_machine_num3}, " +
            "check_machine_name4 = #{check_machine_name4}, check_machine_type4 = #{check_machine_type4}, check_machine_num4 = #{check_machine_num4}, " +
            "check_machine_name5 = #{check_machine_name5}, check_machine_type5 = #{check_machine_type5}, check_machine_num5 = #{check_machine_num5}, " +
            "check_machine_name6 = #{check_machine_name6}, check_machine_type6 = #{check_machine_type6}, check_machine_num6 = #{check_machine_num6}, " +
            "check_machine_name7 = #{check_machine_name7}, check_machine_type7 = #{check_machine_type7}, check_machine_num7 = #{check_machine_num7}, " +
            "check_machine_name8 = #{check_machine_name8}, check_machine_type8 = #{check_machine_type8}, check_machine_num8 = #{check_machine_num8}, " +
            "check_machine_name9 = #{check_machine_name9}, check_machine_type9 = #{check_machine_type9}, check_machine_num9 = #{check_machine_num9}, " +
            "check_machine_name10 = #{check_machine_name10}, check_machine_type10 = #{check_machine_type10}, check_machine_num10 = #{check_machine_num10}, " +
            "check_machine_name11 = #{check_machine_name11}, check_machine_type11 = #{check_machine_type11}, check_machine_num11 = #{check_machine_num11}, " +
            "check_machine_name12 = #{check_machine_name12}, check_machine_type12 = #{check_machine_type12}, check_machine_num12 = #{check_machine_num12}, " +
            "checker = #{checker}, check_date = #{check_date} where product_num = #{product_num} and excel_type = #{excel_type}"})
    void updateItem(@Param("product_num") String product_num, @Param("excel_type") String excel_type, @Param("product_name") String product_name, @Param("product_type") String product_type, @Param("inner_label") String inner_label, @Param("debug_conclusion") String  debug_conclusion, @Param("debuger") String debuger, @Param("debug_date") Date debug_date, @Param("environment_temperature") String environment_temperature, @Param("relative_humidity") String relative_humidity, @Param("power") String power, @Param("is_groud") String is_groud,
                    @Param("check_machine_name1") String check_machine_name1, @Param("check_machine_type1") String check_machine_type1, @Param("check_machine_num1") String check_machine_num1,
                    @Param("check_machine_name2") String check_machine_name2, @Param("check_machine_type2") String check_machine_type2, @Param("check_machine_num2") String check_machine_num2,
                    @Param("check_machine_name3") String check_machine_name3, @Param("check_machine_type3") String check_machine_type3, @Param("check_machine_num3") String check_machine_num3,
                    @Param("check_machine_name4") String check_machine_name4, @Param("check_machine_type4") String check_machine_type4, @Param("check_machine_num4") String check_machine_num4,
                    @Param("check_machine_name5") String check_machine_name5, @Param("check_machine_type5") String check_machine_type5, @Param("check_machine_num5") String check_machine_num5,
                    @Param("check_machine_name6") String check_machine_name6, @Param("check_machine_type6") String check_machine_type6, @Param("check_machine_num6") String check_machine_num6,
                    @Param("check_machine_name7") String check_machine_name7, @Param("check_machine_type7") String check_machine_type7, @Param("check_machine_num7") String check_machine_num7,
                    @Param("check_machine_name8") String check_machine_name8, @Param("check_machine_type8") String check_machine_type8, @Param("check_machine_num8") String check_machine_num8,
                    @Param("check_machine_name9") String check_machine_name9, @Param("check_machine_type9") String check_machine_type9, @Param("check_machine_num9") String check_machine_num9,
                    @Param("check_machine_name10") String check_machine_name10, @Param("check_machine_type10") String check_machine_type10, @Param("check_machine_num10") String check_machine_num10,
                    @Param("check_machine_name11") String check_machine_name11, @Param("check_machine_type11") String check_machine_type11, @Param("check_machine_num11") String check_machine_num11,
                    @Param("check_machine_name12") String check_machine_name12, @Param("check_machine_type12") String check_machine_type12, @Param("check_machine_num12") String check_machine_num12,
                    @Param("checker") String checker, @Param("check_date") Date check_date);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num} and excel_type = #{excel_type}"})
    void deleteAll(@Param("product_num ") String product_num, String excel_type);
}
