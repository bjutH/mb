package com.bjut.MB.dao;

import com.bjut.MB.model.MachineTest;
import com.bjut.MB.model.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
public interface MachineTestDao {
    String TABLE_NAME = "machine_test";
    String INSERT_FIELDS = "product_num, testDemand";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{test_demand}"})
    void addProcess(String product_num,String test_demand);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<MachineTest> selectAll(String product_num);

    @Update({"update ", TABLE_NAME, "set test_data = #{test_data}, test_result = #{test_result}, ps = #{ps} where product_num = #{product_num} and test_demand = #{test_demand}"})
    void UpdateOperaterAndOther(String product_num, String test_data, String test_result, String test_demand, String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void DeleteAll(String product_num);
}
