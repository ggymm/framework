package com.cloud.ninelock.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SyncMapper {
    List<Map<String, Object>> selectGroupList();
}
