package cn.dgut.service.impl;

import cn.dgut.dao.IRoleDao;
import cn.dgut.domain.Permission;
import cn.dgut.domain.Role;
import cn.dgut.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
@Transactional
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String[] permissionIds, String roleId) {
        for(String permissionId:permissionIds){
            roleDao.addPermissionToRole(permissionId, roleId);
        }
    }

}
