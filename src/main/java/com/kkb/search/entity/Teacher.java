package com.kkb.search.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 教师信息表
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@Data
public class Teacher implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 活动id
     */
    private Integer activityId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 列表图片url
     */
    private String image;

    /**
     * 颜值指数
     */
    private Integer appearance;

    /**
     * 颜值指数
     */
    private Integer violence;

    /**
     * 技能
     */
    private String skill;

    /**
     * 任职公司
     */
    private String experience;

    /**
     * 头衔
     */
    private String title;

    /**
     * 自我评价
     */
    private String evaluate;

    /**
     * 优点
     */
    private String merit;

    /**
     * 0：启用 1：停用
     */
    private Integer status;



}
