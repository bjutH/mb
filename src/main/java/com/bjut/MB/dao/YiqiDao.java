package com.bjut.MB.dao;

import com.bjut.MB.model.Memo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Cheng on 2017/10/31.
 */
@Mapper
public interface YiqiDao {
    String TABLE_NAME = "`yiqi_ps`";
    String INSERT_FIELDS = "`product_num`,` ps_name`, `path`";
    String SELECT_FIELDS = "*";
    /**
     *
     * @param product_num 产品编号
     * @param ps_name 备忘录名称
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{product_num}, #{ps_name}, #{path})"})
    void addItem(@Param("product_num") String product_num,@Param("ps_name") String ps_name, @Param("path") String path);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num}"})
    List<Memo> selectAll(@Param("product_num") String product_num);

    /**
     *
     * @param product_num 产品编号
     * @param ps_name 备忘录名称
     * @return
     */
    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where product_num = #{product_num} and ps_name = #{ps_name}"})
    Memo selectOne(@Param("product_num") String product_num, @Param("ps_name") String ps_name);

    @Select({"select DISTINCT path from ", TABLE_NAME, "where product_num = #{product_num}"})
    String selectPath(@Param("product_num") String product_num);

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
     *
     */
    @Update({"update ", TABLE_NAME, "set num = #{num}, pad_id = #{pad_id}, hanjie = #{hanjie} , debug = #{debug}, check = #{check}, soft_num = #{soft_num}, ps = #{ps} where product_num = #{product_num} and ps_name = #{ps_name}"})
    void updateItem(@Param("product_num") String product_num, @Param("ps_name") String ps_name, @Param("num") String num, @Param("pad_id") String pad_id, @Param("hanjie") String hanjie, @Param("debug") String debug, @Param("check") String check, @Param("check") String soft_num, @Param("ps") String ps);

    @Delete({"delete from", TABLE_NAME ,"where product_num = #{product_num}"})
    void deleteAll(@Param("product_name") String product_name);
}
