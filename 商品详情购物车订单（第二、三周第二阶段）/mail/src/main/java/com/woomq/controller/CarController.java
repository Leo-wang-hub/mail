package com.woomq.controller;

import com.sun.xml.internal.ws.policy.sourcemodel.ModelNode;
import com.woomq.pojo.Car;
import com.woomq.pojo.Cart;
import com.woomq.pojo.Product;
import com.woomq.pojo.User;
import com.woomq.service.CarService;
import com.woomq.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author woo-mq
 */
@Controller
public class CarController {
    @Autowired
    GoodsService goodsService;
    @Autowired
    CarService carService;

    /**
     * 获取购物车列表
     * @param model
     * @return
     */
    @GetMapping("/car/getCar")
    public String getCar(Model model){
        Collection<Cart> cars = carService.getCar(1);
        System.out.println(cars);
        model.addAttribute("cars",cars);
        model.addAttribute("carCount",carService.carCounts());
        return "car";
    }

    /**
     * 将商品添加到用户购物车
     * @param productId
     * @param userId
     * @return
     */
    @GetMapping("/toCar")
    public String toCar(@RequestParam("productId")int productId,@RequestParam("userId")int userId){
//        Product product = goodsService.getGoodsListById(productId);
//        //默认添加时数量为1
//        Car car = new Car(userId,product.getProductId(),product,1);

        //将商品添加到购物车
//        carService.addCar(car);
        carService.createCar(productId,userId);

        return "redirect:/car/getCar";
    }

    /**
     * 对购物车商品的数量和小计进行修改
     * @param carId
     * @param productNum
     * @param productPrice
     * @return
     */
    @GetMapping("/car/updateCar")
        public String updateCar(@RequestParam("carId")int carId,@RequestParam("productNum") int productNum,@RequestParam("productPrice")int productPrice){
        if(productNum==0){
            //购物车商品信息为零相当于删除
            carService.deleteCar(carId);
        }
        Cart cart = new Cart(carId, 0, productNum, null, productPrice, productNum, new BigDecimal(productNum*productPrice));

        carService.updateCar(cart);
        System.out.println("进入了更改商品数量的方法");
        return"redirect:/car/getCar";
    }

    /**
     * 删除购物车商品
     * @param carId
     * @return
     */
    @GetMapping("/car/deleteCar")
    public String deleteCar(@RequestParam("carId")int carId){
        carService.deleteCar(carId);
        return "redirect:/car/getCar";
    }

    /**
     * 清空用户购物车
     * @param userId
     * @return
     */
    @GetMapping("/car/cleanCar")
    public String cleanCar(@RequestParam("userId") int userId){
        carService.clearCar(userId);
        return "redirect:/car/getCar";
    }


}
