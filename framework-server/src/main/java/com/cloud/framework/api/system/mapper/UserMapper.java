package com.cloud.framework.api.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.framework.api.system.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 19679
 * @version 创建时间: 2021-11-03 08:59:19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
