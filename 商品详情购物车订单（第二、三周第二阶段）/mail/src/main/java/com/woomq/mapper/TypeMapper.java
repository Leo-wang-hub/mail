package com.woomq.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @auhtor woo-mq
 */
@Mapper
@Repository
public interface TypeMapper {
    /**
     * 根据id获取类型名
     * @param typeId
     * @return
     */
    String getTypeNameById(int typeId);
}
