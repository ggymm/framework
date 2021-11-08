package com.cloud.ninelock.api.service;

import com.cloud.framework.api.system.entity.Dept;
import com.cloud.framework.api.system.mapper.DeptMapper;
import com.cloud.ninelock.api.mapper.SyncMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author gongym
 * @version 创建时间: 2021-11-05 17:04
 */
@Service
public class SyncService {

    @Resource
    private DeptMapper deptMapper;
    @Resource
    private SyncMapper syncMapper;

    public void syncDept() {
        List<Map<String, Object>> groupList = syncMapper.selectGroupList();
        for (Map<String, Object> group : groupList) {
            System.out.println(group);
            Dept dept = new Dept();
            dept.setDeptId((Long) group.get("group_id"));
            if (group.get("p_id") == null) {
                dept.setParentId(-1L);
            } else {
                dept.setParentId((Long) group.get("p_id"));
            }
            dept.setDeptName((String) group.get("group_name"));
            deptMapper.insert(dept);
        }
    }
}
