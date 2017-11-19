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
    String INSERT_FIELDS = "product_num, theory_data";
    String SELECT_FIELDS = "*";
    String SELECT_ONE_FIELDS = "product_num, theory_data";

    /**
     *
     * @param product_num 产品编号
     * @param theory_data 理论数据
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{theory_data}"})
    void addItem(String product_num,String theory_data);

    /**
     *
     * @param product_num 产品编号
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Debug> selectAll(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param theory_data 理论数据
     * @return
     */
    @Select({"select ", SELECT_ONE_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and theory_data = #{theory}"})
    List<Debug> selectOne(String product_num, String theory_data);

    /**
     *
     * @param product_num 产品编号
     * @param observe_data 观测数据
     * @param observe_result 观测结果
     * @param test_machine 检测设备
     * @param machine_type 设备型号
     * @param machine_num 设备编号
     * @param ps 备注
     * @param theory_data 理论数据
     */
    @Update({"update ", TABLE_NAME, "set observe_data = #{observe_data}, observe_result = #{observe_result}, test_machine = #{test_machine} ,machine_type= {machine_type}, machine_num = #{machine_num}, ps = #{ps}, where product_num = #{product_num} and theoryData = #{theory_data}"})
    void updateItem(String product_num, String observe_data, String observe_result, String test_machine, String machine_type, String machine_num, String ps, String theory_data);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);

}
