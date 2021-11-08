package com.cloud.framework.api.iam.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongym
 * @version 创建时间: 2021-11-05 11:55
 */
@RestController
@RequestMapping("iam/login")
public class LoginController {

    @PostMapping
    public String login() {
        return "success";
    }
}
