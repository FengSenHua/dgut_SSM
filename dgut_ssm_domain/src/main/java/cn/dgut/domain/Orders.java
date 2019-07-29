package cn.dgut.domain;

import cn.dgut.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 */
public class Orders {
    //无意义、主键uuid
    private String id;
    //订单编号 不为空 唯一
    private String orderNum;
    //下单时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date orderTime;
    private String orderTimeStr;
    //订单状态(0 未支付 1 已支付)
    private Integer orderStatus;
    private String orderStatusStr;
    //出行人数
    private int peopleCount;
    //支付方式(0 支付宝 1 微信 2其它)
    private Integer payType;
    private String payTypeStr;
    //产品id 外键
    private Product product;
    //旅客id 外键
    private List<Traveller> travellers;
    //会员(联系人）id 外键
    private Member member;
    //订单描述(其它信息)
    private String orderDesc;

    public String getOrderStatusStr() {
        if (orderStatus!=null){
            if (orderStatus==1)
                orderStatusStr="已支付";
            if (orderStatus==0)
                orderStatusStr="未支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
       if (orderTime!=null){
           orderTimeStr= DateUtils.date2String(orderTime,"yyyy-MM-dd HH:mm");
       }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
        //支付方式(0 支付宝 1 微信 2其它)
        if(payType!=null){
            if(payType==0)
                payTypeStr="支付宝";
            if(payType==1)
                payTypeStr="微信";
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
