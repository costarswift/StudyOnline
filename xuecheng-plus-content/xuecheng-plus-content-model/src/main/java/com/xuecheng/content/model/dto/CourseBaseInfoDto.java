package com.xuecheng.content.model.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * @description 课程基本信息dto
 * @author Costar
 * @date 2023/5/21 19:25
 * @version 1.0
 */
@Data
public class CourseBaseInfoDto implements Serializable {

    /**
     * 收费规则，对应数据字典
     */
    private String charge;

    /**
     * 价格
     */
    private Float price;


    /**
     * 原价
     */
    private Float originalPrice;

    /**
     * 咨询qq
     */
    private String qq;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 电话
     */
    private String phone;

    /**
     * 有效期天数
     */
    private Integer validDays;

    /**
     * 大分类名称
     */
    private String mtName;

    /**
     * 小分类名称
     */
    private String stName;
}
