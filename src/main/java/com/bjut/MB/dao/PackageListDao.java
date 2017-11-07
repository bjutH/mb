package com.bjut.MB.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

/**
 * Created by Cheng on 2017/10/31.
 */
public interface PackageListDao {
    String TABLE_NAME = "package_record";
    String INSERT_FIELDS = "product_num, item";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{item})"})
    void addProcess(String product_num,String item);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and item = #{item}"})
    List<Pack> selectConfirmAndPackager(String product_num, String item);

    @Update({"update ", TABLE_NAME, "set confirm = #{confirm}, self_check = #{self_check}, packager = #{packager} where product_num = #{product_num} and item = #{item}"})
    void UpdateConfirmAndPackager(String confirm, String self_check, String packager);

    @Delete({"delete from", TABLE_NAME, "where product_num = #{product_num} and item = #{item}"})
    void DeleteItem(String product_num, String item);
}
