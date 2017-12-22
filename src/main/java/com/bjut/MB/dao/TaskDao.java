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
    String INSERT_FIELDS = "`name`,`task`";
    String SELECT_FIELDS = "task";


    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values ( #{name}, #{task})"})
    void addTask(@Param("name") String name, @Param("task") String task);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where name = #{name}"})
    List<String> selectByName(@Param("name") String name);


    @Update({"update ", TABLE_NAME, "set task = #{task} where name = #{name}"})
    void updateTask(@Param("password") String task, @Param("name") String name);

    /**
     *
     * @param name
     */
    @Delete({"delete from", TABLE_NAME, "where name = #{name}"})
    void deleteAll(@Param("name") String name);

    @Delete({"delete from", TABLE_NAME, "where name = #{name} and task = #{task}"})
    void deleteOneTask(@Param("name") String name, @Param("task") String task);
}
