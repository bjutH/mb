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
    String TABLE_NAME = "`machine_test`";
    String INSERT_FIELDS = "`product_num`, `test_demand`, 'PATH`";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param test_demand 检测要求
     * @param path 路径
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{test_demand}, #{path}"})
    void addItem(@Param("product_num") String product_num,@Param("test_demand") String test_demand, @Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<MachineTest> selectAll(@Param("product_num") String product_num);



    /**
     *
     * @param product_num 产品编号
     * @param test_demand 检验要求
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and test_demand = #{test_demand}"})
    MachineTest selectOne(@Param("product_num") String product_num, @Param("test_demand") String test_demand);

    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);
    /**
     *
     * @param product_num 产品编号
     * @param test_data 检验数据
     * @param test_result 检验结果
     * @param test_demand 检验要求
     * @param ps 备注
     */
    @Update({"update ", TABLE_NAME, "set test_data = #{test_data}, test_result = #{test_result}, ps = #{ps} where product_num = #{product_num} and test_demand = #{test_demand}"})
    void updateItem(@Param("product_num") String product_num, @Param("test_data") String test_data, @Param("test_result") String test_result, @Param("test_demand") String test_demand, @Param("ps") String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(@Param("product_num") String product_num);
}
