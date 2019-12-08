package com.ys.demo.service;

import com.ys.demo.pojo.user;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    @Override
    public boolean userLogin(user user) {
        return false;
    }

    @Override
    public boolean userRegist(user user) {
        return false;
    }

    @Override
    public boolean userUpdate(user user) {
        return false;
    }
}
