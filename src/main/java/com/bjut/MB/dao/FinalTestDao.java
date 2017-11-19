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
    String INSERT_FIELDS = "product_num, name, path";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{name}, #{path})"})
    void addItem(String product_num,String name, String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<FinalTest> selectAll(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param name 名称
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and name = #{name}"})
    FinalTest selectOne(String product_num, String name);

    /**
     *
     * @param product_num 产品编码
     * @param name 名
     * @param check_result 检测结果
     */
    @Update({"update ", TABLE_NAME, "set name = #{name}, check_result = #{check_result} where product_num = #{product_num}"})
    void updateItem(String product_num,String name, String check_result);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
