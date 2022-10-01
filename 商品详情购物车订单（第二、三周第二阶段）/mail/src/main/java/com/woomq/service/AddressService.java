package com.woomq.service;

import com.woomq.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author woo-mq
 */

public interface AddressService {


    /**
     * 添加地址
     * @param address
     * @return
     */
    int addAddress(Address address);

    /**
     * 获取全部地址
     * @return
     */
    Collection<Address> getALLAddress();

    /**
     * 根据addressId删除地址信息
     * @param addressId
     * @return
     */
    int  deleteAddressById(int addressId);

    /**
     * 根据id获取地址信息
     * @param addressId
     * @return
     */
    Address getAddressById(int addressId);
}
