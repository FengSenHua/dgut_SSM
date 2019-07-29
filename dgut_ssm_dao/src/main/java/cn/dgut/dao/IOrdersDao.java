package cn.dgut.dao;

import cn.dgut.domain.Member;
import cn.dgut.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrdersDao {
    @Select("select * from orders")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one =@One(select = "cn.dgut.dao.IProductDao.findById"))
    })
    List<Orders> findAllByPage();

    //根据订单id查询,多表查询
    @Select("select * from orders where id=#{ordersId}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one =@One(select = "cn.dgut.dao.IProductDao.findById")),
            @Result(column = "memberid",property = "member",javaType = Member.class,one = @One(select = "cn.dgut.dao.IMemberDao.findById")),
            @Result(column = "id",property = "travellers",javaType = java.util.List.class,many = @Many(select = "cn.dgut.dao.ITravellerDao.findByOrdersId"))
    })
    Orders findById(String ordersId);
}
