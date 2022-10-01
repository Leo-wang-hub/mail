package com.woomq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author woomq
 * 商品对应的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    /**
     * 商品id
     */
    private int productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品类别
     */
    private int typeId;
    /**
     * 商品描述
     */
    private String productDetail;
    /**
     * 商品价格
     */
    private int productPrice;
    /**
     * 商品图片路径
     */
    private String productImage;
}
