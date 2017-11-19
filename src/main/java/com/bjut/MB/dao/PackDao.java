package com.bjut.MB.dao;

import com.bjut.MB.model.Pack;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
//装箱记录单
public interface PackDao {
    String TABLE_NAME = "pack";
    String INSERT_FIELDS = "product_num, item, path";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param item 名称
     * @param path
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{item}, #{path})"})
    void addItem(String product_num,String item, String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Pack> selectAll(String product_num);


    /**
     *
     * @param product_num 产品编号
     * @param item 名称
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and item = #{item}"})
    Pack selectOne(String product_num, String item);

    /**
     *
     * @param confirm 确认
     * @param self_check 自检项目
     * @param packager 包装人
     * @param product_num 产品编号
     * @param item 名称
     */
    @Update({"update ", TABLE_NAME, "set confirm = #{confirm}, self_check = #{self_check}, packager = #{packager} where product_num = #{product_num} and item = #{item}"})
    void updateItem(String confirm, String self_check, String packager, String product_num, String item);

    /**
     *
     * @param product_num
     */
    @Delete({"delete from", TABLE_NAME, "where product_num = #{product_num}"})
    void deleteAll(String product_num);
}
