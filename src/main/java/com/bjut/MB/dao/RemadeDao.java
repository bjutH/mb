package com.bjut.MB.dao;

import com.bjut.MB.model.Remade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
//返工记录表
public interface RemadeDao {
    String TABLE_NAME = "remade";
    String INSERT_FIELDS = "product_num, date, modify_num, soft_modify_des, handware_modify_des, struct_modify_des, modifyer, checker";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{date}, #{modify_num}, #{soft_modify_des}, #{handware_modify_des}, #{struct_modify_des}, #{modifyer}, #{checker})"})
    void addItem(String product_num,Date date, String modify_num, String soft_modify_des, String handware_modify_des, String struct_modify_des, String modifyer, String checker );

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Remade> selectAll(String product_num);

    @Update({"update ", TABLE_NAME, "set product_num = #{product_num}, date = #{date}, modify_num = #{modify_num}, soft_modify_des = #{soft_modify_des}, handware_modify_des = #{handware_modify_des}, struct_modify_des = #{struct_modify_des}, modifyer = #{modifyer}, checker = #{checker}  where product_num = #{product_num}"})
    void updateItem(String product_num, Date date, String modify_num, String soft_modify_des, String handware_modify_des, String struct_modify_des, String modifyer, String checker);

    @Delete({"delete from", TABLE_NAME , "where product_num = #{product_num}"})
    void deleteAll(String product_num);

}
