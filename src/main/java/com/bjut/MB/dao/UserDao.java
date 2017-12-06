package com.bjut.MB.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/12/6.
 */
@Mapper
public interface UserDao {
    String TABLE_NAME = "`user`";
    String INSERT_FIELDS = "`name`, `password`, `salt`, `power`";
    String SELECT_FIELDS = "*";

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS, ") values (#{name}, #{password}, #{salt}, #{power})"})
    void addItem(@Param("name") String name, @Param("password") String password, @Param("salt") String salt, @Param("power") String power);
}
