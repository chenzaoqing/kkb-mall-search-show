package com.kkb.search.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 报名表
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@Data
public class EnrollVo implements Serializable {

    private static final long serialVersionUID=1L;

	@NotNull(message = "手机号不能为空")
    private String mobile;

    /**
     * openid
     */
	@NotNull(message = "openId不能为空")
    private String openId;

}
