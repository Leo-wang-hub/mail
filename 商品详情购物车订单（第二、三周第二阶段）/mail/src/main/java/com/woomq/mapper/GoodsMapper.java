package com.woomq.mapper;

import com.woomq.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
/**
 * @author woo-mq
 */
public interface GoodsMapper {
    /**
     * 根据类型查询商品
     * @param typeId 商品类型
     * @return Collection<Product>
     */
    Collection<Product> getGoodsListByTypeId(int typeId);

    /**
     * 根据id查询商品信息
     * @param productsId
     * @return Product
     */
    Product getGoodsListById(int productsId);

    /**
     * 根据搜索的关键字进行模糊搜索
     * @param searchName
     * @return  Collection<Product>
     */
    Collection<Product> getSearchList(String searchName);

}
