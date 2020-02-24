package com.kkb.search.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.kkb.core.web.KkbResponse;
import com.kkb.core.web.KkbWebStatus;
import com.kkb.search.domain.TeacherSearchVo;
import com.kkb.search.entity.TeacherSearch;
import com.kkb.search.service.ITeacherSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 选择老师表 前端控制器
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@RestController
@RequestMapping("/teacher/search")
public class TeacherSearchController {

	@Autowired
	private ITeacherSearchService iTeacherSearchService;

	@GetMapping("/{mobile}")
	public KkbResponse info(@PathVariable String mobile) {
		List<TeacherSearch> list = iTeacherSearchService.list(new QueryWrapper<TeacherSearch>().lambda().eq(TeacherSearch::getMobile, mobile));
		Map<String, Object> result = Maps.newHashMap();
		if (CollectionUtils.isEmpty(list)) {
			result.put("status", 0);
		} else {
			result.put("status", 1);
			result.put("ids",list.stream().map(e -> e.getId()).collect(Collectors.toList()));
		}
		return KkbResponse.success(result);
	}

	@PostMapping("/add")
	public KkbResponse add(@RequestBody @Valid TeacherSearchVo teacherSearchVo) {
		if (teacherSearchVo.getTeacherIds().size() < 2 || teacherSearchVo.getTeacherIds().size() > 3) {
			return KkbResponse.failure(KkbWebStatus.ILLEGAL_PARAM);
		}
		List<TeacherSearch> list = iTeacherSearchService.list(new QueryWrapper<TeacherSearch>().lambda().eq(TeacherSearch::getMobile, teacherSearchVo.getMobile()));
		if (!CollectionUtils.isEmpty(list)) {
			return KkbResponse.failure(KkbWebStatus.ILLEGAL_PARAM);
		}
		List<TeacherSearch> addList = Lists.newArrayList();
		teacherSearchVo.getTeacherIds().forEach(id -> {
			TeacherSearch search = new TeacherSearch();
			search.setTeacherId(id);
			search.setMobile(teacherSearchVo.getMobile());
			addList.add(search);
		});
		return iTeacherSearchService.saveBatch(addList) ? KkbResponse.success() : KkbResponse.failure();
	}
}

