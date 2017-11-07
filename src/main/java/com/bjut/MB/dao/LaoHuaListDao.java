package com.bjut.MB.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

/**
 * Created by Cheng on 2017/10/31.
 */
public interface LaoHuaListDao {
    String TABLE_NAME = "laohua";
    String INSERT_FIELDS = "product_num, demand";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{demand})"})
    void addProcess(String product_num,String demand);

    @Select({"select ", SELECT_FIELDS, "from ", TABLE_NAME, "where product_num = #{product_num} and demand = #{demand}"})
    List<Aging> selectResultAndOther(String product_num, String demand);

    @Update({"update ", TABLE_NAME, "set result = #{result}, process_result = #{process_result}, ps = #{ps} debuger = #{debuger} where product_num = #{product_num} and demand = #{demand}"})
    void UpdateResultAndOther(String product_num, String demand, String result, String process_result, String ps, String debuger);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num} and demand = #{demand}"})
    void DeleteItem(String product_num, String demand);
}
