package cn.dgut.dao;

import cn.dgut.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    //根据订单id查询游客
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId);
}
