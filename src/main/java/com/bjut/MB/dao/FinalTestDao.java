package com.bjut.MB.dao;

import com.bjut.MB.model.FinalTest;
import com.bjut.MB.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/11/15.
 */
@Mapper
public interface FinalTestDao {

    String TABLE_NAME = "`final_test`";
    String INSERT_FIELDS = "`product_num`, `name`, `path`";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{name}, #{path})"})
    void addItem(@Param("product_num") String product_num,@Param("name") String name, @Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<FinalTest> selectAll(@Param("product_num") String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param name 名称
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and name = #{name}"})
    FinalTest selectOne(@Param("product_num") String product_num, @Param("name") String name);


    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);
    /**
     *
     * @param product_num 产品编码
     * @param name 名
     * @param check_result 检测结果
     */
    @Update({"update ", TABLE_NAME, "set name = #{name}, check_result = #{check_result} where product_num = #{product_num}"})
    void updateItem(@Param("product_num") String product_num,@Param("name") String name, @Param("check_result") String check_result);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(@Param("product_num") String product_num);
}
