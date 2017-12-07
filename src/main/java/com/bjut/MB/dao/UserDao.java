package com.bjut.MB.dao;

import com.bjut.MB.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Cheng on 2017/12/6.
 */
@Mapper
public interface UserDao {
    String TABLE_NAME = "`user`";
    String INSERT_FIELDS = "`num`,`name`, `password`, `salt`, `power`";
    String SELECT_FIELDS = "*";

    /**
     *
     * @param num 工号
     * @param name 姓名
     * @param password 密码
     * @param salt
     * @param power 级别
     */
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{num}. #{name}, #{password}, #{salt}, #{power})"})
    void addUser(@Param("num") String num, @Param("name") String name, @Param("password") String password, @Param("salt") String salt, @Param("power") String power);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where num = #{num}"})
    List<User> selectOne(@Param("num") String num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where name = #{name}"})
    User selectByName(@Param("name") String name);


    /**
     *
     * @param password 密码
     * @param num 工号
     */

    @Update({"update ", TABLE_NAME, "set password = #{password} where num = #{num}"})
    void updatePassword(@Param("password") String password, @Param("num") String num);


    @Update({"update ", TABLE_NAME, "set power = #{power} where num = #{num}"})
    void updatePower(@Param("power") String power, @Param("num") String num);

    /**
     *
     * @param num
     */
    @Delete({"delete from", TABLE_NAME, "where num = #{num}"})
    void deleteAll(@Param("num") String num);

}
