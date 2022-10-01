package com.woomq.controller;

import com.woomq.pojo.Address;
import com.woomq.service.AddressService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * 地址
 * @author woo-mq
 */
@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    /**
     *查看全部的地址信息
     * @param model
     * @return
     */
    @GetMapping("/address/toAddress")
    String toAddress(Model model){
        Collection<Address> allAddress = addressService.getALLAddress();
        model.addAttribute("addresses",allAddress);
        return "address";
    }
    @GetMapping("/address/toAddAddress")
    public String toAddAddress(){
        return "addAddress";
    }

    /**
     * 添加收货地址
     * @param address
     * @param userId
     * @return
     */
    @GetMapping("/address/addAddress/{userId}")
    public String addAddress(Address address, @PathVariable("userId") int userId){
        address.setAddressUser(userId);
        addressService.addAddress(address);
        return"redirect:/address/toAddress";
    }

    /**
     * 删除指定地址信息
     * @param addressId
     * @return
     */
    @GetMapping("/address/deleteAddress")
    public String  deleteAddress(@RequestParam("addressId")int addressId){
        addressService.deleteAddressById(addressId);
        return "redirect:/address/toAddress";
    }
}
