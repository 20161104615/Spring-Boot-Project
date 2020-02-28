package com.ys.demo.service.lmpl;

import com.ys.demo.bean.UserBean;
import com.ys.demo.mapper.UserMapper;
import com.ys.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean userLogin(UserBean userBean) {
        UserBean finduserbean = userMapper.getUserByuser_phone(userBean.getUser_phone(), userBean.getUser_pwd());
        System.out.println(finduserbean);
        return finduserbean;
    }

    @Override
    public boolean userRegister(UserBean userBean) {
        UserBean userFind = userFind(userBean);
        if (userFind != null) {
            //添加失败,手机号或邮箱重复
            return false;
        } else {
            int insertUser = userMapper.insertUser(userBean);
            if (insertUser != 0) {
                //添加成功
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public boolean userUpdate(UserBean userBean) {
        int updateuser = userMapper.updateuser(userBean);
        if (updateuser != 0) {
            //修改成功
            UserBean finduser = userMapper.finduser(userBean);
            return true;
        } else {
            //修改失败
            return false;
        }
    }

    @Override
    public UserBean userFind(UserBean userBean) {
        UserBean finduser = userMapper.finduser(userBean);
        return finduser;
    }

    @Override
    public UserBean userfindstring(String userphone) {
        UserBean finduserbystring = userMapper.finduserbystring(userphone);
        return finduserbystring;
    }

    @Override
    public ArrayList<UserBean> allUser(boolean userAdministrator) {
        ArrayList<UserBean> allUser = userMapper.findAllUser(userAdministrator);
        return allUser;
    }

    @Override
    public boolean USERUPDATE(UserBean userBean) {
        ArrayList<UserBean> arrayList = userMapper.FINDUSER(userBean);
        if(arrayList.isEmpty()){
            boolean aupdateuser = userMapper.AUPDATEUSER(userBean);
            return aupdateuser;
        } else {
            return false;
        }
    }
}
