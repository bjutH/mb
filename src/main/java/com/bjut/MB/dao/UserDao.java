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
    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{num}, #{name}, #{password}, #{salt}, #{power})"})
    void addUser(@Param("num") String num, @Param("name") String name, @Param("password") String password, @Param("salt") String salt, @Param("power") String power);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where num = #{num}"})
    User selectOne(@Param("num") String num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where name = #{name}"})
    User selectByName(@Param("name") String name);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where id = #{id}"})
    User selectById(@Param("id") int id);

    @Select({"select name,power from", TABLE_NAME})
    List<User> selectAll();


    /**
     *
     * @param password 密码
     * @param name  名称
     */

    @Update({"update ", TABLE_NAME, "set password = #{password} where name = #{name}"})
    void updatePassword(@Param("password") String password, @Param("name") String name);


    @Update({"update ", TABLE_NAME, "set power = #{power} where name = #{name}"})
    void updatePower(@Param("power") String power, @Param("name") String name);

    /**
     *
     * @param name
     */
    @Delete({"delete from", TABLE_NAME, "where name = #{name}"})
    void deleteAll(@Param("name") String name);

}
