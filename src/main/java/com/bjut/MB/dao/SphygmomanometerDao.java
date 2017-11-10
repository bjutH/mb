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
public interface SphygmomanometerDao {
    String TABLE_NAME = "xueyaji";
    String INSERT_FIELDS = "product_num, process";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{serial_num}"})
    void addItem(String product_num,String serial_num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Sphygmomanometer> selectAll(String product_num);

    @Update({"update ", TABLE_NAME, "set real_data = #{real_data}, conclusion = #{conclusion}, ps = #{ps} where product_num = #{product_num} and serial_num = #{serial_num}"})
    void UpdateItem(String product_num, String real_data, String conclusion, String serial_num, String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void DeleteAll(String product_num);
}
