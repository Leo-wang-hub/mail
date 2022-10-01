package com.woomq.service;

import com.woomq.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;


/**
 * @author woo-mq
 */
public interface GoodsService {
    Collection<Product> getGoodsListByTypeId(int typeId);
    Collection<Product> getSearchList(String searchName);

}
