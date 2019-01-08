package com.swp.mybatis.mapper;

import com.swp.mybatis.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM tb_user")
    @Results({
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "userPassword", column = "user_password", jdbcType = JdbcType.VARCHAR),
            @Result(property = "userSex", column = "user_sex", jdbcType = JdbcType.CHAR),
            @Result(property = "userBirthday", column = "user_birthday", jdbcType = JdbcType.DATE)
    })
    List<User> getAllUser();

    @Select("SELECT * FROM tb_user WHERE uid = #{uid}")
    @Results({
            @Result(property = "userName", column = "user_name", jdbcType = JdbcType.VARCHAR),
            @Result(property = "userPassword", column = "user_password", jdbcType = JdbcType.VARCHAR),
            @Result(property = "userSex", column = "user_sex", jdbcType = JdbcType.CHAR),
            @Result(property = "userBirthday", column = "user_birthday", jdbcType = JdbcType.DATE)
    })
    User getUser(int uid);

    @Insert("INSERT INTO tb_user(user_name,user_password,user_sex,user_birthday) VALUES(#{userName}, #{userPassword}, #{userSex}, #{userBirthday})")
    int insertUser(User user);

    @Update("UPDATE tb_user SET user_name = #{userName} WHERE uid = #{uid}")
    int updateUser(User user);

    @Delete("DELETE FROM tb_user WHERE uid = #{uid}")
    int deleteUser(User user);
}
