package com.ys.demo.service;

import com.ys.demo.bean.UserBean;

public interface UserService {
    public UserBean userLogin(UserBean userBean);
    public boolean userRegister(UserBean userBean);
    public boolean userUpdate(UserBean userBean);
    public UserBean userFind(UserBean userBean);
    public UserBean userfindstring(String userphone);
}
