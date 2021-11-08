package com.cloud.framework.api.system.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cloud.framework.api.base.service.BaseService;
import com.cloud.framework.api.common.dto.TreeNode;
import com.cloud.framework.api.system.entity.Dept;
import com.cloud.framework.api.system.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gongym
 * @version 创建时间: 2021-11-05 15:50
 */
@Service
public class DeptService extends BaseService<DeptMapper, Dept> {

    public List<TreeNode> getTree() {
        List<TreeNode> treeList = new ArrayList<>();

        // 查询全部组织列表
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(Dept::getDelFlag, 1)
                .select(Dept::getDeptId, Dept::getParentId, Dept::getDeptName, Dept::getDeptType);
        List<Dept> deptList = this.list(queryWrapper);
        if (deptList.size() == 0) {
            // 没有初始化数据
            // 数据库应该有默认根节点
            return treeList;
        }

        // 构造组织树
        Map<Long, TreeNode> treeNodeMap = deptList.stream().map(node -> new TreeNode(
                        node.getDeptId(),
                        node.getParentId(),
                        node.getDeptName(),
                        new ArrayList<>(),
                        new HashMap<>()))
                .collect(Collectors.toMap(TreeNode::getId, a -> a, (k1, k2) -> k1));
        for (Dept dept : deptList) {
            Long id = dept.getDeptId();
            Long parentId = dept.getParentId();

            TreeNode parent = treeNodeMap.get(parentId);
            if (parent == null || id.equals(parentId)) {
                treeList.add(treeNodeMap.get(id));
            } else {
                parent.getChildren().add(treeNodeMap.get(id));
            }
        }
        return treeList;
    }

}
