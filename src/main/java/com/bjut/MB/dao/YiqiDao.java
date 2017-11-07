package com.bjut.MB.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

/**
 * Created by Cheng on 2017/10/31.
 */
public interface Yiqi {
    String TABLE_NAME = "yiqi_ps";
    String INSERT_FIELDS = "product_num, ps_name";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{ps_name})"})
    void addProcess(String orderNum,String ps_name);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and ps_name = #{ps_name}"})
    String selectOperaterAndOhter(String product_num, String ps_name);

    @Update({"update ", TABLE_NAME, "set num = #{num}, pad_id = #{pad_id}, hanjie = #{hanjie} , debug = #{debug}, check = #{check}, soft_num = #{soft_num}, ps = #{ps} where product_num = #{product_num} and ps_name = #{ps_name}"})
    void UpdateOperaterAndOther(String product_num, String ps_name, String num, String pad_id, String hanjie, String debug, String check, String soft_num, String ps);

    @Delete({"delete from", TABLE_NAME ,"where product_num = #{product_num}, ps_name = #{ps_name}"})
    void DeleteItem(String product_name, String ps_name);
}
