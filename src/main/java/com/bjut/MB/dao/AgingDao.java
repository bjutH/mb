package com.bjut.MB.dao;

import com.bjut.MB.model.Aging;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
//老化观测表
public interface AgingDao {
    String TABLE_NAME = "aging";
    String INSERT_FIELDS = "product_num, demand";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{demand})"})
    void addItem(String product_num,String demand);

    @Select({"select ", SELECT_FIELDS, "from ", TABLE_NAME, "where product_num = #{product_num}"})
    List<Aging> selectAll(String product_num);

    @Update({"update ", TABLE_NAME, "set result = #{result}, process_result = #{process_result}, ps = #{ps} debuger = #{debuger} where product_num = #{product_num} and demand = #{demand}"})
    void updateItem(String product_num, String demand, String result, String process_result, String ps, String debuger);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
