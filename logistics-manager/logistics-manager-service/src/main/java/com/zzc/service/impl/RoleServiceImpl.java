package com.zzc.service.impl;

import com.zzc.mapper.RoleMapper;
import com.zzc.pojo.Role;
import com.zzc.pojo.RoleExample;
import com.zzc.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhangzhaochen
 * @CreateTime: 2024-05-29  22:02
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper mapper;
    @Override
    public List<Role> query(Role role) throws Exception {
        RoleExample example = new RoleExample();
        return mapper.selectByExample(example);
    }

    @Override
    public Role queryById(Integer id) throws Exception{
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addRole(Role role) throws Exception {
        return mapper.insertSelective(role);
    }

    @Override
    public Integer updateRole(Role role) throws Exception {
        return mapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Integer deleteRole(Integer id) throws Exception {
        return mapper.deleteByPrimaryKey(id);
    }
}
