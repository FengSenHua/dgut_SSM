package cn.dgut.controller;

import cn.dgut.domain.Orders;
import cn.dgut.service.IOrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrdersService ordersService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size", required = true,defaultValue = "4") Integer pageSize) {

        List<Orders> ordersList = ordersService.findAllByPage(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("order-list");
        return mv;
    }

    @RequestMapping("/findById.do")
    public  ModelAndView findById(@RequestParam(name="id",required = true) String ordersId){
        ModelAndView mv =new ModelAndView();
        Orders orders=ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
