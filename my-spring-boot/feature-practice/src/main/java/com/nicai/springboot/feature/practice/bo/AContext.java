package com.nicai.springboot.feature.practice.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A业务上下文
 *
 * @author guozhe
 * @date 2020/08/07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AContext implements Context {

    /**
     * 业务类型
     */
    private String businessType;
}