package com.cloud.framework.api.base.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @author gongym
 * @version 创建时间: 2021-11-05 15:58
 */
public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {
}
