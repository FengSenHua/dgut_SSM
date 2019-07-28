package cn.dgut.dao;

import cn.dgut.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProductDao {

    //查询所有产品
    @Select("SELECT * FROM product")
    List<Product> findAll();

    //添加产品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void saveProduct(Product product);

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    Product findById(String id);
}
