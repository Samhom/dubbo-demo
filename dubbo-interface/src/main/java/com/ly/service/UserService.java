package com.ly.service;

import com.ly.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    List<User> findAll();

    @Transactional
    void saveUser(User user);
}
