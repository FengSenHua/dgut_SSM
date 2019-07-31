package cn.dgut.service;

import cn.dgut.domain.Role;
import cn.dgut.domain.UsersInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    List<UsersInfo> findAll();

    void save(UsersInfo usersInfo);

    UsersInfo findById(String id);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roleIds);
}
