package com.zzc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: zhangzhaochen
 * @CreateTime: 2024-05-27  21:16
 * @Description: 页面跳转的控制器
 * @Version: 1.0
 */
@Controller
public class PageController {
    /**
     * Home跳转页面
     *
     * @return
     */
    @RequestMapping(value = {"/", "/home"})
    public String showMain() {
        return "main";
    }

    /**
     * RestFul风格
     *
     * @return
     */
    @RequestMapping("/{path}")
    public String showPage(@PathVariable String path) {
        return path;
    }
}
