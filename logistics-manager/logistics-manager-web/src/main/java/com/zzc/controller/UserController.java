package com.zzc.controller;

import com.bobo.dto.UserDTO;
import com.zzc.pojo.Role;
import com.zzc.pojo.User;
import com.zzc.service.IRoleService;
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

    @Autowired
    private IRoleService iRoleService;

    @GetMapping("/query")
    public String query(User user, Model model) throws Exception {
        List<User> list = service.query(user);
        model.addAttribute("list",list);
        return "user/user";
    }
    @RequestMapping("/userDispatch")
    public String userDispatch(Model model) throws  Exception{
        // 查询所有的角色信息
        List<Role> list = iRoleService.query(new Role());
        model.addAttribute("roles",list);
        return "user/updateUser";
    }
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(UserDTO dto) throws Exception{
        // 1.保存用户信息
        // 2.保存角色和用户的关联关系
        Integer count = service.saveOrUpdate(dto);
        return "redirect:/user/query";
    }

    @RequestMapping("/checkUserName")
    @ResponseBody
    public String checkUserName(User user) throws Exception{
        List<User> list = service.query(user);
        if(list == null || list.size() ==0){
            // 表示根据提交的账号查询不到数据，说明 账号不存在
            return "1";
        }
        return "0";
    }

}
