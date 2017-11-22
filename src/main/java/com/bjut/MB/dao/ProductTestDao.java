package com.bjut.MB.dao;

import com.bjut.MB.model.Order;
import com.bjut.MB.model.ProductTest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
//成品检验报告单
@Mapper
public interface ProductTestDao {
    String TABLE_NAME = "`product_test`";
    String INSERT_FIELDS = "`product_num`, `test_item`, `path`";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param test_item 检测项目
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{test_item}, #{path}"})
    void addItem(@Param("product_num") String product_num,@Param("test_item") String test_item, @Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<ProductTest> selectAll(@Param("product_num") String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param test_item 检验项目
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and test_item = #{test_item}"})
    ProductTest selectOne(@Param("product_num") String product_num, @Param("test_item") String test_item);


    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);
    /**
     *
     * @param product_num 产品编号
     * @param test_item 检验项目
     * @param test_record 实测记录
     * @param item_result 单项结论
     * @param ps 备注
     */
    @Update({"update ", TABLE_NAME, "set test_record = #{test_record}, item_result = #{item_result} where product_num = #{product_num} and test_item = #{test_item}"})
    void updateItem(@Param("product_num") String product_num, @Param("test_item") String test_item, @Param("test_record") String test_record, @Param("item_result") String item_result, @Param("ps") String ps);


    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(@Param("product_num") String product_num);
}
