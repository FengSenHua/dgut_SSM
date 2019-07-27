package cn.dgut.service.impl;

import cn.dgut.dao.IProductDao;
import cn.dgut.domain.Product;
import cn.dgut.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }
}
