package com.kkb.search.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 选择老师表
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@Data
public class TeacherSearch implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 老师id
     */
    private Integer teacherId;

    /**
     * 报名id
     */
    private Integer enrollId;

    /**
     * 选择时间
     */
    private LocalDateTime createTime;



}
