package com.woomq.mapper;

import com.woomq.pojo.Item;
import com.woomq.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author
 * 订单
 */
@Mapper
@Repository
public interface OrderMapper {
    /**
     * 添加订单
     * @param order
     * @return
     */
     int addOrder(Order order);

    /**
     * 添加item
     * @param item
     * @return
     */
     int  addItem(Item item);

    /**
     * 查询订单
     * @param orderId
     * @return
     */
    Order getOrderById(String orderId);

    /**
     * 根据itemId查询item
     * @param orderId
     * @return
     */
    Collection<Item> getItemByOrderId(String orderId);
}
