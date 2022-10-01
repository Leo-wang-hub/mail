package com.woomq.service.Impl;

import com.woomq.mapper.OrderMapper;
import com.woomq.pojo.Address;
import com.woomq.pojo.Cart;
import com.woomq.pojo.Item;
import com.woomq.pojo.Order;
import com.woomq.service.AddressService;
import com.woomq.service.CarService;
import com.woomq.service.OrderService;
import com.woomq.utils.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

/**
 * @author woo-mq
 * 订单
 */
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    CarService carService;
    @Autowired
    AddressService addressService;
    @Autowired
    OrderMapper orderMapper;
    /**
     * 创建订单
     * @param userId
     * @param addressId
     * @return
     */
    @Override
    public String createOrder(int userId, int addressId) {
        //查询用户的购物车
        Collection<Cart> cars = carService.getCar(userId);

        //获取购物车总金额
        BigDecimal order_total = carService.carCounts();
        String orderId = RandomUtils.createOrderId();
        //获取当前日期
        Date date = new Date();
        Order order = new Order(orderId, userId, addressId, new java.sql.Date(date.getTime()), order_total);
        //插入订单表
        this.addOrder(order);
        //将购物车信息添加到item中
        Collection<Item> items = new ArrayList<>();
        for (Cart car : cars) {
            items.add(new Item(orderId,car.getProductId(),car.getProductNum(),car.getProductCount()));
        }
        for (Item item : items) {
            this.addItem(item);
        }
        //订单生成后清空购物车
        carService.clearCar(userId);
        return orderId;
    }

    @Override
    public int addOrder(Order order) {
        orderMapper.addOrder(order);
        return 1;
    }

    @Override
    public int addItem(Item item) {
        orderMapper.addItem(item);
        return 0;
    }

    @Override
    public Order getOrderById(String orderId) {
        return orderMapper.getOrderById(orderId);
    }

    @Override
    public Collection<Item> getItemByOrderId(String orderId) {
        return orderMapper.getItemByOrderId(orderId);
    }
}
