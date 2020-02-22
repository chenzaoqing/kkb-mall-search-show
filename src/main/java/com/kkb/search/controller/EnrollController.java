package com.kkb.search.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkb.core.web.KkbResponse;
import com.kkb.search.domain.EnrollVo;
import com.kkb.search.entity.Activity;
import com.kkb.search.entity.Enroll;
import com.kkb.search.service.IEnrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 报名表 前端控制器
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@RestController
@RequestMapping("/enroll")
public class EnrollController {

	@Autowired
	private IEnrollService iEnrollService;

	@GetMapping("/{mobile}")
	public KkbResponse info(@PathVariable String mobile) {
		List<Enroll> list = iEnrollService.list(new QueryWrapper<Enroll>().lambda().eq(Enroll::getMobile, mobile));
		return KkbResponse.success(CollectionUtils.isEmpty(list) ? 0 : 1);
	}

	@PostMapping("/add")
	public KkbResponse add(@RequestBody @Valid EnrollVo enrollVo) {
		String enrollVoJson = JSON.toJSONString(enrollVo);
		Enroll enroll = JSONObject.parseObject(enrollVoJson, Enroll.class);
		return iEnrollService.save(enroll) ? KkbResponse.success() : KkbResponse.failure();
	}
}

