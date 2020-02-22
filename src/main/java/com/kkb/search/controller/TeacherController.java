package com.kkb.search.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkb.core.web.KkbResponse;
import com.kkb.search.entity.Enroll;
import com.kkb.search.entity.Teacher;
import com.kkb.search.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 教师信息表 前端控制器
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	private ITeacherService iTeacherService;


	@GetMapping("/list")
	public KkbResponse info() {
		return KkbResponse.success(iTeacherService.list(new QueryWrapper<Teacher>().lambda().eq(Teacher::getStatus, 0)));
	}
}

