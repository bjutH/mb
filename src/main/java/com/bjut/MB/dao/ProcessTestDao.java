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
    String INSERT_FIELDS = "product_num, theoryData";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{theoryData}"})
    void addProcess(String product_num,String theoryData);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<ProcessTest> selectOperaterAndOhter(String product_num);

    @Update({"update ", TABLE_NAME, "set testData = #{testData}, testResult = #{testResult}, testMachine = #{testMachine}, machineType = #{machineType},machineNo = #{machineNo}, ps = #{ps} where product_num = #{product_num} and theoryData = #{theoryData}"})
    void UpdateOperaterAndOther(String product_num, String theoryData, String testData, String testResult, String testMachine, String machineType, String machineNo, String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void DeleteItem(String product_num);
}
