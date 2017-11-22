package com.bjut.MB.dao;

import com.bjut.MB.model.Pack;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
//装箱记录单
@Mapper
public interface PackDao {
    String TABLE_NAME = "`pack`";
    String INSERT_FIELDS = "`product_num`, `item`, `path`";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param item 名称
     * @param path
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{item}, #{path})"})
    void addItem(@Param("product_num") String product_num,@Param("item") String item, @Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Pack> selectAll(@Param("product_num") String product_num);


    /**
     *
     * @param product_num 产品编号
     * @param item 名称
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and item = #{item}"})
    Pack selectOne(@Param("product_num") String product_num, @Param("item") String item);


    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);
    /**
     *
     * @param confirm 确认
     * @param self_check 自检项目
     * @param packager 包装人
     * @param product_num 产品编号
     * @param item 名称
     */
    @Update({"update ", TABLE_NAME, "set confirm = #{confirm}, self_check = #{self_check}, packager = #{packager} where product_num = #{product_num} and item = #{item}"})
    void updateItem(@Param("confirm") String confirm, @Param("self_check") String self_check, @Param("packager") String packager, @Param("product_num") String product_num, @Param("item") String item);

    /**
     *
     * @param product_num
     */
    @Delete({"delete from", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(@Param("product_num") String product_num);
}
