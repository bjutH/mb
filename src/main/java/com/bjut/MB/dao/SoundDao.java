package com.bjut.MB.dao;

import com.bjut.MB.model.SoundRecording;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Cheng on 2017/12/8.
 */
@Mapper
public interface SoundDao {
    String TABLE_NAME = "`sound_recording`";
    String SELECT_FIELDS = "*";

    @Update({"update ", TABLE_NAME, "set sound = #{sound} where num = #{num}"})
    void updatePassword(@Param("sound") String sound, @Param("num") int num);

    @Select({"select ", SELECT_FIELDS, "from", TABLE_NAME, "where num = #{num}"})
    SoundRecording selectByNum(@Param("num") int num);

    @Select({"select num,sound from", TABLE_NAME})
    List<SoundRecording> selectAll();

}
