package com.woomq.service;

import com.woomq.pojo.Car;
import com.woomq.pojo.Cart;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author woo-mq
 * carService
 */
public interface CarService {
    /**
     *向购物车中增加商品
     * @param car
     * @return
     */
    int addCar(Car car);

    /**
     * 构建购物车
     * @param productId
     * @param userId
     * @return
     */
    int createCar(int productId,int userId);
    /**
     *查询所有的购物商品
     * @return
     */
    Collection<Cart> getCar(int userId);
    int updateCar(Cart car);

    /**
     * 根据carId删除购物车商品信息
     * @param carId
     * @return
     */
    int deleteCar(int carId);

    /**
     * 清空用户购物车
     * @param usetId
     * @return
     */
    int clearCar(int usetId);

    /**
     * 购物车商品金额总和
     * @return
     */
    BigDecimal carCounts();

    /**
     * 购物车商品数量
     * @return
     */
    int carNums();
    Collection<Cart> getAllCar();
}
