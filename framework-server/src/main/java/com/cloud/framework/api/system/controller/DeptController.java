package com.cloud.framework.api.system.controller;

import com.cloud.framework.api.common.dto.Result;
import com.cloud.framework.api.common.dto.TreeNode;
import com.cloud.framework.api.system.service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gongym
 * @version 创建时间: 2021-11-05 16:39
 */
@RestController
@RequestMapping("system/dept")
public class DeptController {

    @Resource
    private DeptService deptService;

    @GetMapping("getTree")
    public Result<List<TreeNode>> getTree() {
        List<TreeNode> tree = deptService.getTree();
        if (tree.size() == 0) {
            return Result.error("数据库未初始化，没有默认根节点", tree);
        }
        return Result.OK(tree);
    }
}
