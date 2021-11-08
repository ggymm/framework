package com.cloud.framework.api.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author gongym
 * @version 创建时间: 2021-11-05 16:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
    private Long id;
    private Long parentId;
    private String label;
    private List<TreeNode> children;
    private Map<String, Object> params;
}
