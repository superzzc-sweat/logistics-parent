package com.zzc.service;

import com.zzc.pojo.Role;

import java.util.List;

/**
 * @Author: zhangzhaochen
 * @CreateTime: 2024-05-27  21:16
 * @Description: 角色信息
 * @Version: 1.0
 */
public interface IRoleService {
    /**
     * 根据条件查询信息
     * @param role
     * @return
     */
    List<Role> query(Role role) throws Exception;

    Role queryById(Integer id) throws Exception;

    /**
     * 添加用户信息
     * @param role
     * @return
     */
    Integer addRole(Role role) throws Exception;

    /**
     * 更新用户信息
     * @param role
     * @return
     */
    Integer updateRole(Role role) throws Exception;

    /**
     * 根据编号删除用户信息
     * @param id
     * @return
     */
    Integer deleteRole(Integer id) throws Exception;
}
