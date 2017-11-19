package com.bjut.MB.dao;

import com.bjut.MB.model.Order;
import com.bjut.MB.model.Sphygmomanometer;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
//血压计鉴定报告单
public interface SphygmomanometerDao {
    String TABLE_NAME = "xueyaji";
    String INSERT_FIELDS = "product_num, process";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param serial_num 序号
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{serial_num}"})
    void addItem(String product_num,String serial_num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Sphygmomanometer> selectAll(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param date 日期
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and process = #{process}"})
    Sphygmomanometer selectOne(String product_num, String date);

    /**
     *
     * @param product_num 产品编号
     * @param real_data 实际数据
     * @param conclusion 结论
     * @param serial_num 序号
     * @param ps 备注
     * @param path 路径
     */
    @Update({"update ", TABLE_NAME, "set real_data = #{real_data}, conclusion = #{conclusion}, ps = #{ps} ,path = #{path}where product_num = #{product_num} and serial_num = #{serial_num}"})
    void updateItem(String product_num, String real_data, String conclusion, String serial_num, String ps, String path);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
