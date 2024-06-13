package com.zzc.service.impl;

import com.bobo.dto.UserDTO;
import com.zzc.mapper.UserMapper;
import com.zzc.mapper.UserRoleMapper;
import com.zzc.pojo.User;
import com.zzc.pojo.UserExample;
import com.zzc.pojo.UserRoleKey;
import com.zzc.service.IUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public List<User> query(User user) throws Exception {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (user != null) {
            if(user.getUserName()!=null && !"".equals(user.getUserName()) ){
                criteria.andUserNameEqualTo(user.getUserName());
            }
        }
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

    @Override
    public Integer saveOrUpdate(UserDTO dto) throws Exception {
        // 1.添加用户信息
        User user = dto.getUser();
        //需要对密码进行加密  MD5加密+sale（盐值）
        String sale= UUID.randomUUID().toString();
        Md5Hash passwordHash=new Md5Hash(user.getPassword(),sale);
        user.setPassword(passwordHash.toString());
        user.setU1(sale);
        this.addUser(user);
        // 2.分配用户和角色的关联关系
        // 获取分配给当前用户的角色信息
        List<Integer> roleIds = dto.getRoleIds();
        if(roleIds != null && roleIds.size() > 0){
            // 表示分配的有角色信息
            for (Integer roleId : roleIds) {
                // 将用户和角色的关联关系保存到 t_user_role 中
                UserRoleKey userRole = new UserRoleKey();
                userRole.setUserId(user.getUserId());
                userRole.setRoleId(roleId);
                userRoleMapper.insertSelective(userRole);
            }
        }
        return 1;
    }
}
