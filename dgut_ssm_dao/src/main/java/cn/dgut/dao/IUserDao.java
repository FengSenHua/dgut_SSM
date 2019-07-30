package cn.dgut.dao;

import cn.dgut.domain.UsersInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IUserDao {

    //根据用户名查询用户
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "cn.dgut.dao.IRoleDao.findRoleById"))
    }
    )
    public UsersInfo findByUserName(String username);

    //查询所有用户
    @Select("select * from users")
    List<UsersInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UsersInfo usersInfo);
}
