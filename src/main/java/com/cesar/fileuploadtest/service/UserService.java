package com.cesar.fileuploadtest.service;

import com.cesar.fileuploadtest.dao.UserMapper;
import com.cesar.fileuploadtest.model.User;
import com.cesar.fileuploadtest.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by Cesar on 2016/11/11.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User checkLogin(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(username);
        List<User> users = userMapper.selectByExample(example);
        if (users == null || users.size() < 1) {
            return null;
        }
        if (Objects.equals(users.get(0).getPassword(), password)) {
            return users.get(0);
        }
        return null;
    }
}
