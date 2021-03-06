package com.bjut.MB.dao;

import com.bjut.MB.model.Aging;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
//老化观测表
@Mapper
public interface AgingDao {
    String TABLE_NAME = "`aging`";
    String INSERT_FIELDS = "`product_num`, `demand`, `path`";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param demand 要求
     * @param path 路径
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{demand}, #{path})"})
    void addItem(@Param("product_num") String product_num,@Param("demand") String demand, @Param("path") String path);

    /**
     *
     * @param product_num 产品编号
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from ", TABLE_NAME, "where product_num = #{product_num}"})
    List<Aging> selectAll(@Param("product_num") String product_num);

    /**
     *
     * @param product_num 产品标号
     * @param demand 要求
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from ", TABLE_NAME, "where product_num = #{product_num} and demand = #{demand}"})
    Aging selectOne(@Param("product_num") String product_num, @Param("demand") String demand);

    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);


    /**
     *
     * @param product_num 产品编号
     * @param demand 要求
     * @param result 观测结果
     * @param time 观测时间
     * @param phenomenon 故障现象
     * @param process_result 处理结果
     * @param ps 备注
     * @param debuger 调试员
     */
    @Update({"update ", TABLE_NAME, "set result = #{result}, time = #{time}, phenomenon = #{phenomenon}, process_result = #{process_result}, ps = #{ps} ,debuger = #{debuger} where product_num = #{product_num} and demand = #{demand}"})
    void updateItem(@Param("product_num") String product_num, @Param("demand") String demand, @Param("result") String result, @Param("time") Date time, @Param("phenomenon") String phenomenon, @Param("process_result") String process_result, @Param("ps") String ps, @Param("debuger") String debuger);

    /**
     *
     * @param product_num 产品编号
     */
    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
