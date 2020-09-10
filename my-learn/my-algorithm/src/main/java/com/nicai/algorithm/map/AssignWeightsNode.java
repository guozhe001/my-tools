package com.nicai.algorithm.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 加权节点
 *
 * @author guozhe
 * @date 2020/09/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignWeightsNode<T, N extends Number> {
    /**
     * 节点
     */
    private T node;
    /**
     * 权重
     */
    private N weight;
}
