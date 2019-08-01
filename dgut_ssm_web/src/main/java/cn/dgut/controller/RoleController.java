package cn.dgut.controller;

import cn.dgut.domain.Permission;
import cn.dgut.domain.Role;
import cn.dgut.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv=new ModelAndView();
        List<Role> roles=roleService.findAll();
        mv.addObject("roles",roles);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role){
        roleService.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "roleId",required = true) String roleId){
        ModelAndView mv = new ModelAndView();
        //根据id查询角色
        Role role=roleService.findById(roleId);
        //根据id查询角色没有添加的权限
        List<Permission> permissionList=roleService.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;

    }
    //对角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "ids",required = true) String[] permissionId,
                                        @RequestParam(name = "roleId",required = true) String roleId){
        roleService.addPermissionToRole(permissionId,roleId);
        return "redirect:findAll.do";
    }

}
