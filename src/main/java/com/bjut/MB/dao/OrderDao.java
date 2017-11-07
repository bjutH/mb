package com.bjut.MB.dao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;



/**
 * Created by Administrator on 2017/10/31.
 */
@Mapper
public interface OrderDao {
    String TABLE_NAME = "suigongdan";
    String INSERT_FIELDS = "product_num, process";
    String SELECT_FIELDS = "operater, other, ps";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{process}"})
    void addProcess(String product_num,String process);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and process = #{process}"})
    List<Order> selectOperaterAndOhter(String product_num, String process);

    @Update({"update ", TABLE_NAME, "set operater = #{operater}, other = #{other}, ps = #{ps} where product_num = #{product_num} and process = #{process}"})
    void UpdateOperaterAndOther(String product_num, String process, String other, String ps);
}
