package com.zzc.controller;

import com.zzc.pojo.Role;
import com.zzc.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: zhangzhaochen
 * @CreateTime: 2024-05-29  23:04
 * @Description: TODO
 * @Version: 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService service;

    @RequestMapping("/query")
    public String query(Role role, Model model) throws Exception {
        List<Role> list = service.query(role);
        model.addAttribute("list",list);
        return "role/role";
    }

    /**
     * 处理跳转页面
     * @return
     */
    @RequestMapping("/roleDispatch")
    public String handlePageDispatch(Integer id,Model model) throws Exception {
        if (id != null) {
            //表示更新
            Role role = service.queryById(id);
            model.addAttribute("role",role);
        }
        //角色添加
        return "role/updateRole";
    }

    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(Role role) throws Exception {
        if (role.getRoleId() != null && role.getRoleId() > 0) {
            //表示更新角色
            service.updateRole(role);
        } else {
            service.addRole(role);
        }
        return "redirect:/role/query";
    }
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) throws Exception {
        service.deleteRole(id);
        return "redirect:/role/query";
    }
}
