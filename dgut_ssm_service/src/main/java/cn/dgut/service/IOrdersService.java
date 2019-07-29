package cn.dgut.service;

import cn.dgut.domain.Orders;

import java.util.List;

public interface IOrdersService {
    //查询所有订单
    List<Orders> findAllByPage(int page,int pageSize);

    Orders findById(String ordersId);
}
