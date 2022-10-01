package com.woomq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @author woo-mq
 */
public class Type {
    /**
     * 类型id
     */
    private int typeId;
    /**
     * 类型名
     */
    private String typeName;

}
