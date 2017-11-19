package com.bjut.MB.dao;

import com.bjut.MB.model.FinalTest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/11/19.
 */
public interface HeaderDao {
    String TABLE_NAME = "header";
    String INSERT_FIELDS = "product_num, product_name, product_type, inner_label, debug_conclusion, debuger, debug_date, environment_temperature, relative_humidity, power, is_groud";
    String SELECT_FIELDS = "*";
    String SELECT_ONE_FIELDS = "product_num";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num})"})
    void addItem(String product_num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Header> selectAll(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Header> selectOne(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param product_name 产品名称
     * @param product_type 产品类型
     * @param inner_label 内部标记
     * @param debug_conclusion 调试结论
     * @param debuger 调试人员
     * @param debug_date 调试日期
     * @param environment_temperature 环境温度
     * @param relative_humidity 相对湿度
     * @param power 供电电源
     * @param is_groud 是否有效接地
     */
    @Update({"update ", TABLE_NAME, "set product_name = #{product_name}, product_type = #{product_type}, inner_label = #{inner_label}, debug_conclusion = #{debug_conclusion}, debuger = #{debuger}, debug_date = #{debug_date}, environment_temperature = #{environment_temperature}, relative_humidity = #{relative_humidity}, power = #{power}, is_groud = #{is_groud} where product_num = #{product_num}"})
    void updateItem(String product_num, String product_name, String product_type, String inner_label, String  debug_conclusion, String debuger, Date debug_date, String environment_temperature, String relative_humidity, String power, String is_groud);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
