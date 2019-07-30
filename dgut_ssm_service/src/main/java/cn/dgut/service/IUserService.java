package cn.dgut.service;

import cn.dgut.domain.UsersInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UsersInfo> findAll();

    void save(UsersInfo usersInfo);

    UsersInfo findUserByIdAndAllRole(String id);
}
