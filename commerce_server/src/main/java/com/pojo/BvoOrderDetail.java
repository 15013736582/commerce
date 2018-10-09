package com.pojo;

        import java.util.Date;
        import java.util.List;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-08 22:09
 **/
public class BvoOrderDetail extends BvoOrder {
    public BvoOrderDetail(Integer id, String title, Double price, Integer qty, Integer isPay, Integer uId, Date createDate) {
        super(id, title, price, qty, isPay, uId, createDate);
    }

    public BvoOrderDetail(){

    }

    private BOrderItem orderItem;
    private List<BOrderItem> orderItems;

    public BOrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(BOrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public List<BOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<BOrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
