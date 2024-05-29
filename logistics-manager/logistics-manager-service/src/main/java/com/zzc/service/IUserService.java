package com.zzc.service;

import com.zzc.pojo.User;

import java.util.List;

/**
 * @Author: zhangzhaochen
 * @CreateTime: 2024-05-27  21:16
 * @Description: 用户信息
 * @Version: 1.0
 */
public interface IUserService {
    /**
     * 根据条件查询信息
     * @param user
     * @return
     */
    List<User> query(User user) throws Exception;

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    Integer addUser(User user) throws Exception;

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user) throws Exception;

    /**
     * 根据编号删除用户信息
     * @param id
     * @return
     */
    Integer deleteUser(Integer id) throws Exception;
}
