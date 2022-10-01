package com.woomq.pojo;

import java.math.BigDecimal;

/**
 * @author woo-mq
 * 生成订单后 保存购物车信息
 */
public class Item {
    /**
     * item编号
     */
    private int itemId;
    /**
     *订单编号
     */
    private String orderId;
    /**
     * 商品编号
     */
    private int productId;
    /**
     * 商品数量
     */
    private int productNum;
    /**
     * 商品小计
     */
    private BigDecimal productCount;

    public Item(String orderId, int productId, int productNum, BigDecimal productCount) {
        this.orderId = orderId;
        this.productId = productId;
        this.productNum = productNum;
        this.productCount = productCount;
    }
}

