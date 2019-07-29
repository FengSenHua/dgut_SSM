package cn.dgut.controller;

import cn.dgut.domain.Product;
import cn.dgut.service.IProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * 查询所有产品
     * @return
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") Integer size){
        List<Product> productList = productService.findAllByPage(page, size);
        PageInfo pageInfo=new PageInfo(productList);
        ModelAndView mv=new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    //产品添加
    @RequestMapping("/saveProduct.do")
    public String save(Product product){
        productService.saveProduct(product);
        return "redirect:findAll.do";
    }
}
