package cn.dgut.dao;

import cn.dgut.domain.Product;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IProductDao {

    //查询所有产品
    @Select("SELECT * FROM product")
    List<Product> findAll();
}
