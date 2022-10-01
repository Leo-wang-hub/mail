package com.woomq.service.Impl;

import com.woomq.mapper.CarMapper;
import com.woomq.mapper.GoodsMapper;
import com.woomq.pojo.Car;
import com.woomq.pojo.Cart;
import com.woomq.pojo.Product;
import com.woomq.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;

/**
 * @author woo-mq
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarMapper carMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public int addCar(Car car) {
        carMapper.addCar(car);
        return 0;
    }

    @Override
    public Collection<Cart> getCar(int userId) {
        return carMapper.getCar(userId);
    }

    @Override
    public int updateCar(Cart car) {
        carMapper.updateCar(car);
        return 0;
    }

    @Override
    public int deleteCar(int carId) {
        carMapper.deleteCar(carId);
        return 0;
    }

    @Override
    public int clearCar(int usetId) {
        carMapper.deleteCarAll(usetId);
        return 0;
    }

    /**
     * 创建购物车
     * @param productId
     * @param userId
     * @return
     */
    @Override
    public int createCar(int productId, int userId) {
        //获得商品对象
        Product goodsListById = goodsMapper.getGoodsListById(productId);
        int productNum=0;
        //使用map将参数封装
        HashMap<String, Object> carMap = new HashMap<String, Object>();
        carMap.put("productId",productId);
        carMap.put("userId",userId);
        System.out.println(carMap);
        Cart carbyProductId = carMapper.getCarbyProuctId(carMap);
        if(carbyProductId==null){
            //第一次添加购物车
            productNum=1;
            Car car = new Car(userId,goodsListById.getProductId(),goodsListById,productNum);
            carMapper.addCar(car);
        }else{
            productNum=carbyProductId.getProductNum()+1;
            System.out.println(productNum);
            System.out.println(carbyProductId.getProductPrice());
            System.out.println(productNum*(carbyProductId.getProductPrice()));
            Cart cart = new Cart(carbyProductId.getCarId(), 0, productNum, null, goodsListById.getProductPrice(), productNum, new BigDecimal(productNum*(goodsListById.getProductPrice())));
            System.out.println("进入了方法"+cart);
            this.updateCar(cart);
        }


        return 0;
    }

    /**
     * 计算购物车的账单总和
     * @return
     */
    @Override
    public BigDecimal carCounts(){
        Collection<Cart> allProduct = carMapper.getAllProduct();
        BigDecimal amount=new BigDecimal(0);
        for (Cart cart : allProduct) {
            amount=amount.add(cart.getProductCount());
        }
        return amount;
    }

    /**
     * 购物车商品总数
     * @return
     */
    @Override
    public int carNums(){
        Collection<Cart> allProduct = carMapper.getAllProduct();
        int nums=0;
        for (Cart cart : allProduct) {
            nums++;
        }
        return nums;
    }

    @Override
    public Collection<Cart> getAllCar() {
        return carMapper.getAllProduct();
    }
}
