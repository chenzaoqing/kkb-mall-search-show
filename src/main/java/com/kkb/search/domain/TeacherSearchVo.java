package com.kkb.search.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 选择老师表
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@Data
public class TeacherSearchVo implements Serializable {

    private static final long serialVersionUID=1L;


    /**
     * 老师id
     */
	@NotNull(message = "选择的老师不能为空")
    private List<Integer> teacherIds;

    /**
     * 报名id
     */
	@NotNull(message = "手机号不能为空")
    private String mobile;




}
