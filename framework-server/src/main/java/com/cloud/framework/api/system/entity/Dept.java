package com.cloud.framework.api.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 19679
 * @version 创建时间: 2021-11-05 15:37:32
 */
@Data
@TableName("sys_dept")
@Accessors(chain = true)
public class Dept {
    /**
     * 组织ID
     */
    @TableId(value = "dept_id", type = IdType.AUTO)
    private Long deptId;
    /**
     * 父组织ID
     */
    @TableField(value = "parent_id")
    private Long parentId;
    /**
     * 父组织路径
     */
    @TableField(value = "parent_path")
    private String parentPath;
    /**
     * 组织名称
     */
    @TableField(value = "dept_name")
    private String deptName;
    /**
     * 组织类型
     */
    @TableField(value = "dept_type")
    private Integer deptType;
    /**
     * 创建者ID
     */
    @TableField(value = "create_id", fill = FieldFill.INSERT)
    private Long createId;
    /**
     * 创建时间
     */
    @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private java.util.Date createTime;
    /**
     * 更新者ID
     */
    @TableField(value = "update_id", fill = FieldFill.INSERT_UPDATE)
    private Long updateId;
    /**
     * 更新时间
     */
    @com.fasterxml.jackson.annotation.JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @org.springframework.format.annotation.DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private java.util.Date updateTime;
    /**
     * 删除标识（-1：不存在；1：存在）
     */
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private Byte delFlag;
}
