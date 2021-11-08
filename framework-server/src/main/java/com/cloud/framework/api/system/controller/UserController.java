package com.cloud.framework.api.system.controller;

import com.cloud.framework.api.system.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gongym
 * @version 创建时间: 2021-11-02 22:55
 */
@RestController
@RequestMapping("system/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("getPage")
    public String getPage() {
        return userService.getPage();
    }
}
