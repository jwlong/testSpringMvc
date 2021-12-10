package com.dxfjyygy.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dxfjyygy.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    User getUserById(@Param("id") Long id);

    List<User> getUserList(User user);
}
