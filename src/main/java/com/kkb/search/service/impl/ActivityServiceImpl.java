package com.kkb.search.service.impl;

import com.kkb.search.entity.Activity;
import com.kkb.search.mapper.ActivityMapper;
import com.kkb.search.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 活动表 服务实现类
 * </p>
 *
 * @author kkb
 * @since 2020-02-22
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements IActivityService {

}
