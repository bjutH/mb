package com.bjut.MB.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

/**
 * Created by Cheng on 2017/10/31.
 */
public interface RebackRecordDao {
    String TABLE_NAME = "fangong_record_list";
    String INSERT_FIELDS = "product_num, date, modify_num, soft_modify_des, handware_modify_des, struct_modify_des, modifyer, checker";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{date}, #{modify_num}, #{soft_modify_des}, #{handware_modify_des}, #{struct_modify_des}, #{modifyer}, #{checker})"})
    void addProcess(String product_num,String date, String modify_num, String soft_modify_des, String handware_modify_des, String struct_modify_des, String modifyer, String checker );

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Remade> selectRebackList(String product_num);

    @Update({"update ", TABLE_NAME, "set product_num = #{product_num}, date = #{date}, modify_num = #{modify_num}, soft_modify_des = #{soft_modify_des}, handware_modify_des = #{handware_modify_des}, struct_modify_des = #{struct_modify_des}, modifyer = #{modifyer}, checker = #{checker}  where product_num = #{product_num}"})
    void UpdateRebackList(String product_num,String date, String modify_num, String soft_modify_des, String handware_modify_des, String struct_modify_des, String modifyer, String checker);

    @Delete({"delete from", TABLE_NAME , "where product_num = #{product_num}"})
    void DeleteItem(String product_num);

}
