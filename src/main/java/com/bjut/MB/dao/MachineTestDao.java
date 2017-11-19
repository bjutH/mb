package com.bjut.MB.dao;

import com.bjut.MB.model.MachineTest;
import com.bjut.MB.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
//整机检验报告单
@Mapper
public interface MachineTestDao {
    String TABLE_NAME = "machine_test";
    String INSERT_FIELDS = "product_num, test_demand";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param test_demand 检测要求
     * @param path 路径
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{test_demand}, #{path}"})
    void addItem(String product_num,String test_demand, String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<MachineTest> selectAll(String product_num);



    /**
     *
     * @param product_num 产品编号
     * @param test_demand 检验要求
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and test_demand = #{test_demand}"})
    MachineTest selectOne(String product_num, String test_demand);

    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(String product_num);
    /**
     *
     * @param product_num 产品编号
     * @param test_data 检验数据
     * @param test_result 检验结果
     * @param test_demand 检验要求
     * @param ps 备注
     */
    @Update({"update ", TABLE_NAME, "set test_data = #{test_data}, test_result = #{test_result}, ps = #{ps} where product_num = #{product_num} and test_demand = #{test_demand}"})
    void updateItem(String product_num, String test_data, String test_result, String test_demand, String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
