package com.cloud.framework.api;

import cn.hutool.json.JSONUtil;
import com.cloud.Application;
import com.cloud.framework.api.common.dto.TreeNode;
import com.cloud.framework.api.system.service.DeptService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gongym
 * @version 创建时间: 2021-11-07 15:26
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DeptServiceTest {

    @Resource
    private DeptService deptService;

    @Test
    public void testGetTree() {
        List<TreeNode> tree = deptService.getTree();
        System.out.println(JSONUtil.toJsonStr(tree));
    }
}
