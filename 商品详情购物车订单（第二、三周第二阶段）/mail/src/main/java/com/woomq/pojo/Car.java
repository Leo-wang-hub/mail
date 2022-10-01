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
public class Car {
    /**
     * 购物车编号
     */
    private int carId;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 商品id
     */
    private int productId;
    /**
     * 关联的商品类
     */
    private Product product;
    /**
     * 商品数量
     */
    private int productNum;
    /**
     * 商品小计
     */
    private BigDecimal productCount;

    /**
     * 有参构造
     * @param userId
     * @param productId
     * @param productNum
     */
    public Car(int userId,int productId,Product product,int productNum) {
        this.userId = userId;
        this.productId = productId;
        this.productNum = productNum;
        this.product=product;
    }
    /**
     *商品小计
     *
     */
    public BigDecimal getProductCount() {
        return  new BigDecimal(this.productNum*this.product.getProductPrice());
    }



}
