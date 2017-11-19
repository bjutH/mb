package com.bjut.MB.dao;

import com.bjut.MB.model.Remade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.Date;
import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
//返工记录表
public interface RemadeDao {
    String TABLE_NAME = "remade";
    String INSERT_FIELDS = "product_num, date, modify_num, soft_modify_des, handware_modify_des, struct_modify_des, modifyer, checker";
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
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{date}, #{modify_num}, #{soft_modify_des}, #{handware_modify_des}, #{struct_modify_des}, #{modifyer}, #{checker})"})
    void addItem(String product_num,Date date, String modify_num, String soft_modify_des, String handware_modify_des, String struct_modify_des, String modifyer, String checker );

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Remade> selectAll(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param date 日期
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and date = #{date}"})
    Remade selectOne(String product_num, String date);

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
     * @param path 路径
     */
    @Update({"update ", TABLE_NAME, "set product_num = #{product_num}, date = #{date}, modify_num = #{modify_num}, soft_modify_des = #{soft_modify_des}, handware_modify_des = #{handware_modify_des}, struct_modify_des = #{struct_modify_des}, modifyer = #{modifyer}, checker = #{checker}, path = #{path} where product_num = #{product_num}"})
    void updateItem(String product_num, Date date, String modify_num, String soft_modify_des, String handware_modify_des, String struct_modify_des, String modifyer, String checker,String path);

    @Delete({"delete from", TABLE_NAME , "where product_num = #{product_num}"})
    void deleteAll(String product_num);

}
