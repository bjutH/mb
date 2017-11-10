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
public interface ProductTestDao {
    String TABLE_NAME = "product_test";
    String INSERT_FIELDS = "product_num, test_item";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{test_item}"})
    void addItem(String product_num,String test_item);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<ProductTest> selectAll(String product_num);

    @Update({"update ", TABLE_NAME, "set test_record = #{test_record}, item_result = #{item_result}, ps = #{ps} where product_num = #{product_num} and test_item = #{test_item}"})
    void UpdateItem(String product_num, String test_item, String test_record, String item_result, String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void DeleteAll(String product_num);
}
