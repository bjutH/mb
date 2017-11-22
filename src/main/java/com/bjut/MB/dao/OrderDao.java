package com.bjut.MB.dao;
import com.bjut.MB.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by Administrator on 2017/10/31.
 */
//随工单表
@Mapper
public interface OrderDao {
    String TABLE_NAME = "`order`";
    String INSERT_FIELDS = "`product_num`, `process`, `path`";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param process 工序名称
     * @param path 路径
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,") values (#{product_num},#{process},#{path})"})
    void addItem(@Param("product_num") String product_num,@Param("process") String process,@Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Order> selectAll(@Param("product_num") String product_num);

    /**
     *
     * @param product_num 产品标号
     * @param process 工序
     * @return
     */
    @Select({"select ", "from", TABLE_NAME, "where product_num = #{product_num} and process = #{process}"})
    Order selectOne(@Param("product_num") String product_num, @Param("process") String process);


    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);
    /**
     *
     * @param product_num 产品编号
     * @param operater 操作者
     * @param process 工序名称
     * @param other 其他内容说明
     * @param ps 备注
     */
    @Update({"update ", TABLE_NAME, "set operater = #{operater}, other = #{other}, ps = #{ps} where product_num = #{product_num} and process = #{process}"})
    void updateItem(@Param("product_num") String product_num,@Param("operater") String operater,@Param("process") String process,@Param("other") String other,@Param("ps") String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(@Param("product_num") String product_num);

}
