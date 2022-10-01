package com.woomq.service;

import com.woomq.pojo.Item;
import com.woomq.pojo.Order;

import java.util.Collection;

/**
 * @author woo-mq
 */
public interface OrderService {
    /**
     * 创建订单
     * @param userId
     * @param addressId
     * @return
     */
     String createOrder(int userId, int addressId);

    /**
     * 向订单中插入信息
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 添加item
     * @param item
     * @return
     */
    int addItem(Item item);

    /**
     * getOrderById
     * @param orderId
     */
    Order getOrderById(String orderId);

    /**
     *订单商品详情
     * @param orderId
     */
    Collection <Item> getItemByOrderId(String orderId);
}

