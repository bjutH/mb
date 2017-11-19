package com.bjut.MB.dao;

import com.bjut.MB.model.Order;
import com.bjut.MB.model.ProductTest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
//成品检验报告单
public interface ProductTestDao {
    String TABLE_NAME = "product_test";
    String INSERT_FIELDS = "product_num, test_item";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param test_item 检测项目
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{test_item}"})
    void addItem(String product_num,String test_item);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<ProductTest> selectAll(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param test_item 检验项目
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and test_item = #{test_item}"})
    ProductTest selectOne(String product_num, String test_item);
    /**
     *
     * @param product_num 产品编号
     * @param test_item 检验项目
     * @param test_record 实测记录
     * @param item_result 单项结论
     * @param ps 备注
     * @param path 路径
     */
    @Update({"update ", TABLE_NAME, "set test_record = #{test_record}, item_result = #{item_result}, ps = #{ps}, path = #{path} where product_num = #{product_num} and test_item = #{test_item}"})
    void updateItem(String product_num, String test_item, String test_record, String item_result, String ps, String path);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
