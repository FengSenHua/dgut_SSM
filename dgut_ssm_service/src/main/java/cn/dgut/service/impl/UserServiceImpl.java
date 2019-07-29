package cn.dgut.service.impl;

import cn.dgut.dao.IUserDao;
import cn.dgut.domain.UsersInfo;
import cn.dgut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsersInfo usersInfo = userDao.findByUserName(s);
        //处理自己的用户对象封装成UserDetails
        User user=new User(usersInfo.getUsername(),"{noop}"+usersInfo.getPassword(),getAuthority());
        return user;
    }
    //作用返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return list;
    }
}
