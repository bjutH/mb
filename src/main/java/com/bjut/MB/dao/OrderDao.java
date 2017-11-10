package com.bjut.MB.dao;
import com.bjut.MB.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;


/**
 * Created by Administrator on 2017/10/31.
 */
@Mapper
//随工单表
public interface OrderDao {
    String TABLE_NAME = "order";
    String INSERT_FIELDS = "product_num, process";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{process}"})
    void addItem(String product_num,String process);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Order> selectAll(String product_num);

    @Update({"update ", TABLE_NAME, "set operater = #{operater}, other = #{other}, ps = #{ps} where product_num = #{product_num} and process = #{process}"})
    void updateItem(String product_num, String operater, String process, String other, String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);

}
