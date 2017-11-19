package com.bjut.MB.dao;

import com.bjut.MB.model.Order;
import com.bjut.MB.model.PerformTest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
//性能要求检验单
public interface PerformTestDao {
    String TABLE_NAME = "perform_test";
    String INSERT_FIELDS = "product_num, serial_num, path";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param serial_num 序号
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{serial_num}, #{path}"})
    void addItem(String product_num,String serial_num, String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<PerformTest> selectAll(String product_num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and serial_num = #{serial_num}"})
    PerformTest selectOne(String product_num, String serial_num);

    /**
     *
     * @param product_num 产品编号
     * @param serial_num 序号
     * @param real_data 实际数据
     * @param conclusion 结论
     * @param ps 备注

     */
    @Update({"update ", TABLE_NAME, "set real_data = #{real_data}, conclusion = #{conclusion}, ps = #{ps} where product_num = #{product_num} and serial_num = #{serial_num}"})
    void updateItem(String product_num, String serial_num, String real_data, String conclusion, String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
