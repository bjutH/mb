package com.bjut.MB.dao;

import com.bjut.MB.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Cheng on 2017/12/22.
 */
@Mapper
public interface TaskDao {
    String TABLE_NAME = "`task`";
    String INSERT_FIELDS = "`num`, `name`,`task`";
    String SELECT_FIELDS = "*";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{num}, #{name}, #{task})"})
    void addUser(@Param("num") String num, @Param("name") String name, @Param("task") String task);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where num = #{num}"})
    List<User> selectOne(@Param("num") String num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where name = #{name}"})
    User selectByName(@Param("name") String name);






    @Update({"update ", TABLE_NAME, "set task = #{task} where num = #{num}"})
    void updatePassword(@Param("password") String task, @Param("num") String num);

    /**
     *
     * @param num
     */
    @Delete({"delete from", TABLE_NAME, "where num = #{num}"})
    void deleteAll(@Param("name") String num);
}
