package com.kkb.search.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkb.core.web.KkbResponse;
import com.kkb.core.web.KkbWebStatus;
import com.kkb.search.entity.Activity;
import com.kkb.search.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 活动表 前端控制器
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	private IActivityService iActivityService;


	@GetMapping("/info")
	public KkbResponse info() {
		List<Activity> list = iActivityService.list(new QueryWrapper<Activity>().lambda().eq(Activity::getStatus, 1));
		if (CollectionUtils.isEmpty(list) || list.size() > 1) {
			return KkbResponse.failure();
		}
		return KkbResponse.success(list.get(0));
	}

}

