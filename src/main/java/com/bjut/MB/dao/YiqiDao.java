package com.bjut.MB.dao;

import com.bjut.MB.model.Memo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
public interface YiqiDao {
    String TABLE_NAME = "yiqi_ps";
    String INSERT_FIELDS = "product_num, ps_name";
    String SELECT_FIELDS = "*";
    /**
     *
     * @param product_num 产品编号
     * @param ps_name 备忘录名称
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{ps_name})"})
    void addItem(String product_num,String ps_name);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Memo> selectAll(String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param ps_name 备忘录名称
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and ps_name = #{ps_name}"})
    Memo selectOne(String product_num, String ps_name);

    /**
     *
     * @param product_num 产品编号
     * @param ps_name 备忘录名称
     * @param num 编号
     * @param pad_id 板号
     * @param hanjie 焊接
     * @param debug 调试
     * @param check 检验
     * @param soft_num 软件版本号
     * @param ps 备注
     * @param path 路径
     */
    @Update({"update ", TABLE_NAME, "set num = #{num}, pad_id = #{pad_id}, hanjie = #{hanjie} , debug = #{debug}, check = #{check}, soft_num = #{soft_num}, ps = #{ps} ,path = #{path} where product_num = #{product_num} and ps_name = #{ps_name}"})
    void updateItem(String product_num, String ps_name, String num, String pad_id, String hanjie, String debug, String check, String soft_num, String ps, String path);

    @Delete({"delete from", TABLE_NAME ,"where product_num = #{product_num}"})
    void deleteAll(String product_name);
}
