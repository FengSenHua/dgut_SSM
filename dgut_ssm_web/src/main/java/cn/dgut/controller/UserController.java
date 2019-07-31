package cn.dgut.controller;

import cn.dgut.domain.Role;
import cn.dgut.domain.UsersInfo;
import cn.dgut.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //查询所有用户
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<UsersInfo> userList = userService.findAll();
        mv.addObject("userList", userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveUser(UsersInfo usersInfo) {
        userService.save(usersInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView findUserById(@RequestParam(name = "id", required = true) String id) {
        ModelAndView mv = new ModelAndView();
        UsersInfo usersInfo = userService.findById(id);
        mv.addObject("user", usersInfo);
        mv.setViewName("user-show");
        return mv;
    }

    //查询用户异界用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userId) {
        ModelAndView mv=new ModelAndView();
        //1.根据用户id查询用户
        UsersInfo usersInfo = userService.findById(userId);
        // 根据用户id查询可以添加的角色
        List<Role> otherRoles=userService.findOtherRoles(userId);
        mv.addObject("user",usersInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }
    //对用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,
                                @RequestParam(name = "ids",required = true) String[] roleIds){
    userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";

    }
}
