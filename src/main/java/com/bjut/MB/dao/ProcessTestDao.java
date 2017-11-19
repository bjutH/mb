package com.bjut.MB.dao;

import com.bjut.MB.model.Order;
import com.bjut.MB.model.ProcessTest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
//工序检验报告单
public interface ProcessTestDao {
    String TABLE_NAME = "process_test";
    String INSERT_FIELDS = "product_num, test_item, path";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param test_item 检验项目
     * @param path 路径
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{test_item}, #{path}"})
    void addItem(String product_num,String test_item, String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<ProcessTest> selectAll(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param test_item 检验项目
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and test_item = #{test_item}"})
    ProcessTest selectOne(String product_num, String test_item);

    /**
     *
     * @param product_num 产品编号
     * @param test_item 检验项目
     * @param test_data 检验数据
     * @param test_result 检验结果
     * @param test_machine 检验设备
     * @param machine_type 设备类型
     * @param machine_no 设备编号
     * @param ps 备注
     */
    @Update({"update ", TABLE_NAME, "set test_data = #{test_data}, test_result = #{test_result}, test_machine = #{test_machine}, machine_type = #{machine_type},machine_no = #{machine_no}, ps = #{ps} where product_num = #{product_num} and test_item = #{test_item}"})
    void updateItem(String product_num, String test_item, String test_data, String test_result, String test_machine, String machine_type, String machine_no, String ps);
    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
