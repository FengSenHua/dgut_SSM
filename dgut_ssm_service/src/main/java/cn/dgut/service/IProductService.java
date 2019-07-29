package cn.dgut.service;

import cn.dgut.domain.Product;

import java.util.List;

public interface IProductService {
   //查询所有产品
   public List<Product> findAllByPage(int page,int size);
   //添加产品
   public void saveProduct(Product product);
}
