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
public interface OrderDao {
    String TABLE_NAME = "suigongdan";
    String INSERT_FIELDS = "product_num, process";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{process}"})
    void addProcess(String product_num,String process);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Order> selectOperaterAndOhter(String product_num);

    @Update({"update ", TABLE_NAME, "set operater = #{operater}, other = #{other}, ps = #{ps} where product_num = #{product_num} and process = #{process}"})
    void UpdateOperaterAndOther(String product_num, String operater, String process, String other, String ps);

    @Delete({"delete from ", TABLE_NAME, "where product_num = #{product_num}"})
    void DeleteItem(String product_num);

}
