package com.dxfjyygy.service;



import com.dxfjyygy.model.User;

import java.util.List;

public interface UserService {
    /**
     * get one user by id
     * @param id
     * @return
     */
    User getUserById(Long id);

    /**
     * 查询列表
     * @param user
     * @return
     */
    List<User> getUserList(User user);

    void addUser (User user);

    void updateUser (User user);

    void deleteUser(User user);
}
