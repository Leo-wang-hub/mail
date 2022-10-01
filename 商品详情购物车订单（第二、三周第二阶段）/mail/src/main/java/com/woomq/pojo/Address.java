package com.woomq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *@author woo-mq
 * 收货地址
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    /**
     * 地址id
     */
    int addressId;
    /**
     * 地址关联用户
     */
    int addressUser;
    /**
     * 收货电话
     */
    String addressPhone;
    /**
     * 详细地址
     */
    String addressDetail;
    /**
     * 收货人姓名
     */
    String addressPerson;

    public Address(int addressUser, String addressPhone, String addressDetail, String addressPerson) {
        this.addressUser = addressUser;
        this.addressPhone = addressPhone;
        this.addressDetail = addressDetail;
        this.addressPerson = addressPerson;
    }
}
