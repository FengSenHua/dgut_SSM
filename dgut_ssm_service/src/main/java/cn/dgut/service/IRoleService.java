package cn.dgut.service;

import cn.dgut.domain.Permission;
import cn.dgut.domain.Role;

import java.util.List;

public interface IRoleService {

    //查询所有角色
    List<Role> findAll();
    //添加用户
    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermission(String roleId);

    void addPermissionToRole(String[] permissionId, String roleId);
}
