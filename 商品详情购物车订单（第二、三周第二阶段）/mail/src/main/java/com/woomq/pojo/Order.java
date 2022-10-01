package com.woomq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * @author woo-mq
 * 订单类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 收货地址
     */
    private int addressId;
    /**
     * 订单生成日期
     */
    private Date orderDate;
    /**
     * 订单总金额
     */
    private BigDecimal orderTotal;
}
