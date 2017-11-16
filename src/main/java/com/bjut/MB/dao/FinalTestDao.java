package com.bjut.MB.dao;

import com.bjut.MB.model.FinalTest;
import com.bjut.MB.model.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/11/15.
 */
public interface FinalTestDao {

    String TABLE_NAME = "final_test";
    String INSERT_FIELDS = "product_num, machine_type, inner_label, check_result, checker, check_date, final_checker, final_check_date, name, random_result";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 仪器编号
     * @param machine_type 仪器型号
     * @param inner_label 内部标记
     * @param check_result 检验结果
     * @param checker 检验员
     * @param check_date 检验日期
     * @param final_checker 核验人
     * @param final_check_date 核验放行日期
     * @param name 名称
     * @param random_result 确认数量、检验结果合格-不合格
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{machine_type}, #{inner_label}, #{check_result}, #{checker}, #{check_date}, #{final_checker}, #{final_check_date}, #{name}, #{random_result}"})
    void addItem(String product_num, String machine_type, String inner_label, String check_result, String checker, Date check_date, String final_checker, Date final_check_date, String name, String random_result);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<FinalTest> selectAll(String product_num);


    /**
     *
     * @param product_num 仪器编号
     * @param machine_type 仪器型号
     * @param inner_label 内部标记
     * @param check_result 检验结果
     * @param checker 检验员
     * @param check_date 检验日期
     * @param final_checker 核验人
     * @param final_check_date 核验放行日期
     * @param name 名称
     * @param random_result 确认数量、检验结果合格-不合格
     */
    @Update({"update ", TABLE_NAME, "set machine_type = #{machine_type}, inner_label = #{inner_label}, check_result = #{check_result}, checker = #{checker}, check_date = #{check_date}, final_checker = #{final_checker}, final_check_date = #{final_check_date}, name = #{name}, random_result = #{random_result} where product_num = #{product_num}"})
    void updateItem(String product_num,String machine_type, String inner_label, String check_result, String checker, Date check_date, String final_checker, Date final_check_date, String name, String random_result);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
