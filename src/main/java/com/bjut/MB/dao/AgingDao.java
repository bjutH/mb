package com.bjut.MB.dao;

import com.bjut.MB.model.Aging;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
//老化观测表
public interface AgingDao {
    String TABLE_NAME = "aging";
    String INSERT_FIELDS = "product_num, demand";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param demand 要求
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{demand})"})
    void addItem(String product_num,String demand);

    /**
     *
     * @param product_num 产品编号
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from ", TABLE_NAME, "where product_num = #{product_num}"})
    List<Aging> selectAll(String product_num);

    /**
     *
     * @param product_num 产品标号
     * @param demand 要求
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from ", TABLE_NAME, "where product_num = #{product_num} and demand = #{demand}"})
    Aging selectOne(String product_num, String demand);

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
     * @param path 路径
     */
    @Update({"update ", TABLE_NAME, "set result = #{result}, time = #{time}, phenomenon = #{phenomenon}, process_result = #{process_result}, ps = #{ps} ,debuger = #{debuger}, path = #{path} where product_num = #{product_num} and demand = #{demand}"})
    void updateItem(String product_num, String demand, String result, Date time, String phenomenon, String process_result, String ps, String debuger, String path);

    /**
     *
     * @param product_num 产品编号
     */
    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
