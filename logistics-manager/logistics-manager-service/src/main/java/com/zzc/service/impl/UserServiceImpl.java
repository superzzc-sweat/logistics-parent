package com.zzc.service.impl;

import com.zzc.mapper.UserMapper;
import com.zzc.pojo.User;
import com.zzc.pojo.UserExample;
import com.zzc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangzhaochen
 * @CreateTime: 2024-05-28  21:06
 * @Description: 用户管理实现类
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;
    @Override
    public List<User> query(User user) throws Exception {
        UserExample example = new UserExample();
        return mapper.selectByExample(example);
    }

    @Override
    public Integer addUser(User user) throws Exception {

        return mapper.insertSelective(user);
    }

    @Override
    public Integer updateUser(User user) throws Exception {

        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer deleteUser(Integer id) throws Exception {
        return mapper.deleteByPrimaryKey(id);
    }
}
