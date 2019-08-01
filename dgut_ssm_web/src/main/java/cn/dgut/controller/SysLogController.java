package cn.dgut.controller;

import cn.dgut.domain.SysLog;
import cn.dgut.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<SysLog> sysLogList=sysLogService.findAll();
        mv.addObject("sysLogList",sysLogList);
        mv.setViewName("syslog-list");
        return mv;
    }
}
