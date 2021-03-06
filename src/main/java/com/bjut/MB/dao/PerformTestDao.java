package com.bjut.MB.dao;

import com.bjut.MB.model.Order;
import com.bjut.MB.model.PerformTest;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Cheng on 2017/11/10.
 */
//性能要求检验单
@Mapper
public interface PerformTestDao {
    String TABLE_NAME = "`perform_test`";
    String INSERT_FIELDS = "`product_num`, `serial_num`, `path`";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param serial_num 序号
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{serial_num}, #{path}"})
    void addItem(@Param("product_num") String product_num,@Param("String serial_num") String serial_num, @Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<PerformTest> selectAll(@Param("product_num") String product_num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and serial_num = #{serial_num}"})
    PerformTest selectOne(@Param("product_num") String product_num, @Param("serial_num") String serial_num);


    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);
    /**
     *
     * @param product_num 产品编号
     * @param serial_num 序号
     * @param real_data 实际数据
     * @param conclusion 结论
     * @param ps 备注

     */
    @Update({"update ", TABLE_NAME, "set real_data = #{real_data}, conclusion = #{conclusion}, ps = #{ps} where product_num = #{product_num} and serial_num = #{serial_num}"})
    void updateItem(@Param("product_num") String product_num, @Param("serial_num") String serial_num, @Param("real_data") String real_data, @Param("conclusion") String conclusion, @Param("ps") String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(@Param("product_num") String product_num);
}
