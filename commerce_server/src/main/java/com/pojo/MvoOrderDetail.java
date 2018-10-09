package com.pojo;

import java.util.Date;

/**
 * @author: hokitlee
 * @description:
 * @create: 2018-10-09 03:37
 **/
public class MvoOrderDetail extends BOrderItem {

    private BvoOrder bvoOrder;
    private Pro pro;

    public MvoOrderDetail(Integer id, Integer oId, Integer pId, Integer count) {
        super(id, oId, pId, count);
    }

    public MvoOrderDetail() {
    }

    public BvoOrder getBvoOrder() {
        return bvoOrder;
    }

    public void setBvoOrder(BvoOrder bvoOrder) {
        this.bvoOrder = bvoOrder;
    }

    public Pro getPro() {
        return pro;
    }

    public void setPro(Pro pro) {
        this.pro = pro;
    }
}
