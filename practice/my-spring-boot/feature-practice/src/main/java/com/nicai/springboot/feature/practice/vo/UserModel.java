package com.nicai.springboot.feature.practice.vo;

import com.nicai.enums.GenderEnum;
import com.nicai.springboot.feature.practice.annotations.ApiModelPropertyAdvance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 此类为了测试动态的swagger文档
 *
 * @author apple
 */
@Data
@ApiModel
@ApiModelPropertyAdvance(ApiModelPropertyAdvance.None.class)
public class UserModel {

    @ApiModelPropertyAdvance(GenderEnum.class)
    @ApiModelProperty(notes = "男")
    private String gender;
}
