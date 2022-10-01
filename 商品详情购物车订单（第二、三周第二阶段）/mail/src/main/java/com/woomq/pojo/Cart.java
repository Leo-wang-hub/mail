package com.woomq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author woo-mq
 *购物车实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    /**
     * 购物车列表编号
     */
    private int carId;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 商品id
     */
    private  int productId;
    /**
     *商品名称
     */
    private String productName;

    private int productPrice;
    /**
     * 商品数量
     */
    private int productNum;
    /**
     * 商品小计
     */
    private BigDecimal productCount;







}
