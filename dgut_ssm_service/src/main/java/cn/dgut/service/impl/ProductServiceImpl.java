package cn.dgut.service.impl;

import cn.dgut.dao.IProductDao;
import cn.dgut.domain.Product;
import cn.dgut.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//涉及事务操作所需要的注解
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    public List<Product> findAllByPage(int page,int size) {
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }


    public void saveProduct(Product product) {
        productDao.saveProduct(product);
    }
}
