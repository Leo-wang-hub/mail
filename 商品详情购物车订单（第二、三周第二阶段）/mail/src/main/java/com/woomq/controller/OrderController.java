package com.woomq.controller;

import com.woomq.pojo.Address;
import com.woomq.pojo.Cart;
import com.woomq.pojo.Item;
import com.woomq.pojo.Product;
import com.woomq.service.AddressService;
import com.woomq.service.CarService;
import com.woomq.service.GoodsService;
import com.woomq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * 订单
 * @Author woo-mq
 */
@Controller
public class OrderController {
    @Autowired
    CarService carService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    AddressService addressService;
    @Autowired
    OrderService orderService;

    /**
     * 生成订单预览
     * @param addressId
     * @param model
     * @return
     */
    @GetMapping("/order/orderReview")
    public String orderReview(@RequestParam("addressId") int addressId, Model model){
        Collection<Cart> cars = carService.getAllCar();
        //获得商品的综合信息
        for (Cart car : cars) {
            Product goodsListById = goodsService.getGoodsListById(car.getProductId());
            car.setProductName(goodsListById.getProductName());
            car.setProductPrice(goodsListById.getProductPrice());
        }
        System.out.println(cars);
        model.addAttribute("cars",cars);
        model.addAttribute("total",carService.carCounts());
        model.addAttribute("address",addressService.getAddressById(addressId));
        return "order";
    }
    @GetMapping("/order/createOrder")

    public String createOrder(@RequestParam("userId") int userId,@RequestParam("addressId")int addressId,Model model){
        System.out.println(userId);
        System.out.println(addressId);
        //创建订单 并返回订单编号
        String orderId = orderService.createOrder(userId, addressId);
        //查询订单
        com.woomq.pojo.Order order = orderService.getOrderById(orderId);
        model.addAttribute("order",order);
        model.addAttribute("address",addressService.getAddressById(order.getAddressId()).getAddressDetail());
        return "createOrder";
    }
    @GetMapping("/order/orderDetail")
    @ResponseBody
    public String orderDetail(@RequestParam("orderId") String orderId){
        System.out.println(orderId);
        //根据orderId查询item
        Collection<Item> itemByOrderId = orderService.getItemByOrderId(orderId);

        return "order";
    }
}
