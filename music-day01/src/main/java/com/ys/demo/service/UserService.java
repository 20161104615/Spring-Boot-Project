package com.ys.demo.service;

import com.ys.demo.pojo.user;

public interface UserService {
    public boolean userLogin(user user);
    public boolean userRegist(user user);
    public boolean userUpdate(user user);
}
