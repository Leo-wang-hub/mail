package com.woomq.mapper;

import com.woomq.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author woo-mq
 */
@Mapper
@Repository
public interface AddressMapper {
    /**
     * 添加地址
     * @param address
     * @return
     */
    int addAddress(Address address);

    /**
     * 获取全部地址信息
     * @return
     */
    Collection<Address> getAllAddress();

    /**
     * 根据addressId删除地址信息
     * @param addressId
     * @return
     */
    int deleteAddressById(int addressId);

    /**
     * 根据id获得地址信息
     * @param addressId
     * @return
     */
    Address getAddressById(int addressId);
}
