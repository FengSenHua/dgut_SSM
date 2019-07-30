package cn.dgut.service.impl;

import cn.dgut.dao.IUserDao;
import cn.dgut.domain.Role;
import cn.dgut.domain.UsersInfo;
import cn.dgut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsersInfo usersInfo = userDao.findByUserName(s);
        //处理自己的用户对象封装成UserDetails
        //usersInfo.getStatus()==0?false:true 0表示用户不可以，否则表示可以使用
       // User user=new User(usersInfo.getUsername(),"{noop}"+usersInfo.getPassword(),getAuthority(usersInfo.getRoles()));
        User user=new User(usersInfo.getUsername(),usersInfo.getPassword(),usersInfo.getStatus()==0?false:true,true,true,true,getAuthority(usersInfo.getRoles()));
        return user;
    }
    //作用返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
       for (Role role:roles){
           list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
       }
       return list;
    }

    @Override
    public List<UsersInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UsersInfo usersInfo) {
        //对密码进行加密
    usersInfo.setPassword(bCryptPasswordEncoder.encode(usersInfo.getPassword()));
        userDao.save(usersInfo);
    }

    @Override
    public UsersInfo findUserByIdAndAllRole(String id) {
        return null;
    }
}
