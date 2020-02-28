package com.ys.demo.service;

import com.ys.demo.bean.UserBean;

import java.util.ArrayList;

public interface UserService {
    public UserBean userLogin(UserBean userBean);
    public boolean userRegister(UserBean userBean);
    public boolean userUpdate(UserBean userBean);
    public UserBean userFind(UserBean userBean);
    public UserBean userfindstring(String userphone);
    public ArrayList<UserBean> allUser(boolean userAdministrator);
    public boolean USERUPDATE(UserBean userBean);
}
