package com.woomq.mapper;

import com.woomq.pojo.Car;
import com.woomq.pojo.Cart;
import com.woomq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

/**
 * @author woo-mq
 */
@Mapper
@Repository
public interface CarMapper {
    /**
     *向购物车中增加商品
     * @param car
     * @return
     */
   int addCar(Car car);

    /**
     * 根据商品id查询用户购物车
     * @Param Map
     *
     * @return
     */
   Cart getCarbyProuctId(Map carMap);
    /**
     *查询购物列表
     * @param userId
     * @return
     */
   Collection<Cart> getCar(int userId);

    /**
     *修改购物车商品信息
     * @param car
     * @return
     */
   int updateCar(Cart car);

    /**
     * 根据carId删除购物车商品信息
     * @param carId
     * @return
     */
   int deleteCar(int carId);

    /**
     * 根据userid删除购物车商品信息
     * @param userId
     * @return
     */
   int deleteCarAll(int userId);

    /**
     * 查询购物车的所有商品
     * @return
     */
   Collection<Cart> getAllProduct();

}
