package com.woomq.service.Impl;

import com.woomq.mapper.AddressMapper;
import com.woomq.pojo.Address;
import com.woomq.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author woo-mq
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public int addAddress(Address address) {
        addressMapper.addAddress(address);
        return 0;
    }

    @Override
    public Collection<Address> getALLAddress() {
        return addressMapper.getAllAddress();
    }

    @Override
    public int deleteAddressById(int addressId) {
        addressMapper.deleteAddressById(addressId);
        return 0;
    }

    @Override
    public Address getAddressById(int addressId) {
        return addressMapper.getAddressById(addressId);
    }
}
