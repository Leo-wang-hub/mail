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
     * @apiNote 根据类型
     * @return
     */
    Collection<Product> getGoodsListByTypeId(int typeId);

    /**
     * @apiNote 根据搜索的关键字进行模糊搜索
     * @param searchName
     * @return
     */
    Collection<Product> getSearchList(String searchName);
}
