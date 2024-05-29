package com.zzc.controller;

import com.zzc.pojo.User;
import com.zzc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zhangzhaochen
 * @CreateTime: 2024-05-28  21:23
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService service;
    @GetMapping("/query")
    public String query(User user, Model model) throws Exception {
        List<User> list = service.query(user);
        model.addAttribute("list",list);
        return "user/user";

    }
}
