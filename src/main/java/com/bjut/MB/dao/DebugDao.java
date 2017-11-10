package com.bjut.MB.dao;

import com.bjut.MB.model.Debug;
import com.bjut.MB.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
//整机调试报告单
public interface DebugDao {
    String TABLE_NAME = "debug";
    String INSERT_FIELDS = "product_num, theoryData";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{theoryData}"})
    void addProcess(String product_num,String theoryData);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Debug> select(String product_num);

    @Update({"update ", TABLE_NAME, "set observeData = #{observeData}, observeResult = #{observeResult}, testMachine = #{testMachine} ,machineType= {machineType}, machineNum = #{machineNum}, ps = #{ps}, where product_num = #{product_num} and theoryData = #{theoryData}"})
    void UpdateOperaterAndOther(String product_num, String observeData, String observeResult, String testMachine, String machineType, String machineNum, String ps, String theoryData);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void DeleteItem(String product_num);

}
