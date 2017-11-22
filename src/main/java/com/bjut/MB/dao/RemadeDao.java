package com.bjut.MB.dao;

import com.bjut.MB.model.Remade;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
//返工记录表
@Mapper
public interface RemadeDao {
    String TABLE_NAME = "`remade`";
    String INSERT_FIELDS = "`product_num`, `date`, `modify_num`, `soft_modify_des`, `handware_modify_des`, `struct_modify_des`, `modifyer`, `checker`, `path`";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param product_num 产品编号
     * @param date 日期
     * @param modify_num 更改单号
     * @param soft_modify_des 软件更改内容简述
     * @param handware_modify_des 硬件更改内容简述
     * @param struct_modify_des 结构更改内容简述
     * @param modifyer 更改人
     * @param checker 检查人
     * @param path 路径
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{date}, #{modify_num}, #{soft_modify_des}, #{handware_modify_des}, #{struct_modify_des}, #{modifyer}, #{checker}, #{path})"})
    void addItem(@Param("product_num") String product_num,@Param("date") Date date, @Param("modify_num") String modify_num, @Param("soft_modify_des") String soft_modify_des, @Param("handware_modify_des") String handware_modify_des, @Param("struct_modify_des") String struct_modify_des, @Param("modifyer") String modifyer, @Param("checker") String checker, @Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Remade> selectAll(@Param("product_num") String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param date 日期
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and date = #{date}"})
    Remade selectOne(@Param("product_num") String product_num, @Param("date") String date);


    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param date 日期
     * @param modify_num 更改单号
     * @param soft_modify_des 软件更改内容简述
     * @param handware_modify_des 硬件更改简述
     * @param struct_modify_des 结构更改简述
     * @param modifyer 更改人
     * @param checker 检查人
     */
    @Update({"update ", TABLE_NAME, "set product_num = #{product_num}, date = #{date}, modify_num = #{modify_num}, soft_modify_des = #{soft_modify_des}, handware_modify_des = #{handware_modify_des}, struct_modify_des = #{struct_modify_des}, modifyer = #{modifyer}, checker = #{checker} where product_num = #{product_num}"})
    void updateItem(@Param("product_num") String product_num, @Param("date") Date date, @Param("modify_num") String modify_num, @Param("soft_modify_des") String soft_modify_des, @Param("handware_modify_des") String handware_modify_des, @Param("struct_modify_des") String struct_modify_des, @Param("modifyer") String modifyer, @Param("checker") String checker);

    @Delete({"delete from", TABLE_NAME , "where product_num = #{product_num}"})
    void deleteAll(@Param("product_num") String product_num);

}
