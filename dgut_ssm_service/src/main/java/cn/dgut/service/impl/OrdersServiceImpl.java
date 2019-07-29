package cn.dgut.service.impl;

import cn.dgut.dao.IOrdersDao;
import cn.dgut.domain.Orders;
import cn.dgut.service.IOrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAllByPage(int page,int pageSize) {
        //参数pageNum是页码值   参数pageSize代表是每页显示条数
        PageHelper.startPage(page,pageSize);
        return ordersDao.findAllByPage();
    }

    @Override
    public Orders findById(String ordersId) {
        return ordersDao.findById(ordersId);
    }
}
