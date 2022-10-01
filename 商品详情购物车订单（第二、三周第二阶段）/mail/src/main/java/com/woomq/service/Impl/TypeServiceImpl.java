package com.woomq.service.Impl;

import com.woomq.mapper.GoodsMapper;
import com.woomq.mapper.TypeMapper;
import com.woomq.pojo.Product;
import com.woomq.service.GoodsService;
import com.woomq.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
/**
 * @author woo-mq
 */
public class TypeServiceImpl implements TypeService{
    @Autowired
    TypeMapper typeMapper;
    @Override
    public String getTypeNameById(int typeId) {
        return typeMapper.getTypeNameById(typeId);
    }
}
