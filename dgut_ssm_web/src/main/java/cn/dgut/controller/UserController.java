package cn.dgut.controller;

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
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<UsersInfo> userList=userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String saveUser(UsersInfo usersInfo){
        userService.save(usersInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserById(@RequestParam(name = "id",required = true) String id){
       UsersInfo usersInfo=userService. findUserByIdAndAllRole(id);
        ModelAndView mv = new ModelAndView();
        return mv;
    }
}
