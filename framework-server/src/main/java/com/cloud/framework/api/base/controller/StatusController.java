package com.cloud.framework.api.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gongym
 * @version 创建时间: 2021-11-03 08:45
 */
@RestController
public class StatusController {

    @GetMapping("/")
    public String serverStatus() {
        return "start success";
    }
}
