package com.woomq.service.Impl;

import com.woomq.mapper.GoodsMapper;
import com.woomq.pojo.Product;
import com.woomq.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
/**
 * @author woo-mq
 */
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public Collection <Product> getGoodsListByTypeId(int typeId) {
        return goodsMapper.getGoodsListByTypeId(typeId);
    }

    @Override
    public Collection<Product> getSearchList(String searchName) {
        return goodsMapper.getSearchList(searchName);
    }
}
