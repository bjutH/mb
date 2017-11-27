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

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Header> selectAll(@Param("product_num") String product_num);

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
     * @param check_machine_name 检测设备名称
     * @param check_machine_type 检测设备类型
     * @param check_machine_num  检测设备编号
     * @param checker 核验/放行人
     * @param check_date 核验/放行日期
     */
    @Update({"update ", TABLE_NAME, "set product_name = #{product_name}, product_type = #{product_type}, inner_label = #{inner_label}, debug_conclusion = #{debug_conclusion}, debuger = #{debuger}, debug_date = #{debug_date}, environment_temperature = #{environment_temperature}, relative_humidity = #{relative_humidity}, power = #{power}, is_groud = #{is_groud}, check_machine_name = #{check_machine_name}, check_machine_type = #{check_machine_type}, check_machine_num = #{check_machine_num}, checker = #{checker}, check_date = #{check_date} where product_num = #{product_num}"})
    void updateItem(@Param("product_num") String product_num, @Param("product_name") String product_name, @Param("product_type") String product_type, @Param("inner_label") String inner_label, @Param("debug_conclusion") String  debug_conclusion, @Param("debuger") String debuger, @Param("debug_date") Date debug_date, @Param("environment_temperature") String environment_temperature, @Param("relative_humidity") String relative_humidity, @Param("power") String power, @Param("is_groud") String is_groud, @Param("check_machine_name") String check_machine_name, @Param("check_machine_type") String check_machine_type, @Param("check_machine_num") String check_machine_num, @Param("checker") String checker, @Param("check_date") Date check_date);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(@Param("product_num ") String product_num);
}
