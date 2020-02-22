package com.kkb.search.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 报名表
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@Data
public class Enroll implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String mobile;

    /**
     * openid
     */
    private String openId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;



}
