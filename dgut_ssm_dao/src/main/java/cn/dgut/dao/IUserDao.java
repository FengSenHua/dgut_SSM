package cn.dgut.dao;

import cn.dgut.domain.UsersInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

public interface IUserDao {

    //根据用户名查询用户
    @Select("select * from users where username=#{username}")
    public UsersInfo findByUserName(String username);
}
