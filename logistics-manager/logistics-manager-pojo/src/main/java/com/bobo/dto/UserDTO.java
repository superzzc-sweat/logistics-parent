package com.bobo.dto;

import com.zzc.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * @Author: zhangzhaochen
 * @CreateTime: 2024-06-11  20:52
 * @Description: TODO 用户
 * @Version: 1.0
 */
@Data
public class UserDTO {

    public User user;

    public List<Integer> roleIds;

}
