package com.cloud.framework.api.system.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author 19679
 * @version 创建时间: 2021-11-03 08:59:19
 */
@Data
@TableName("sys_user")
@Accessors(chain = true)
public class User {
    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;
    /**
     * 用户名称
     */
    @TableField(value = "username")
    private String username;
    /**
     * 用户性别
     */
    @TableField(value = "gender")
    private String gender;
    /**
     * 用户状态
     */
    @TableField(value = "status")
    private Integer status;
    /**
     * 所属组织ID
     */
    @TableField(value = "org_id")
    private Long orgId;
    /**
     * 所属组织名称
     */
    @TableField(value = "org_name")
    private String orgName;
    /**
     * 所属根组织ID
     */
    @TableField(value = "org_root_id")
    private Long orgRootId;
    /**
     * 创建者ID
     */
    @TableField(value = "create_id", fill = FieldFill.INSERT)
    private Long createId;
    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private java.util.Date updateTime;
    /**
     * 删除标识（-1：不存在；1：存在）
     */
    @TableField(value = "del_flag", fill = FieldFill.INSERT)
    private Byte delFlag;
}
