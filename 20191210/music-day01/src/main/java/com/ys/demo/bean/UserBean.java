package com.ys.demo.bean;

import java.util.Date;
import java.util.Objects;

public class UserBean {
    private Integer user_id;
    private String user_name;//昵称
    private String user_phone;//手机号
    private String user_pwd;//密码
    private String user_avatar;//头像
    private Date user_birthday;//生日
    private String user_email;//邮箱
    private String user_introduced;//个人介绍

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_introduced() {
        return user_introduced;
    }

    public void setUser_introduced(String user_introduced) {
        this.user_introduced = user_introduced;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserBean)) return false;
        UserBean userBean = (UserBean) o;
        return Objects.equals(user_id, userBean.user_id) &&
                Objects.equals(user_name, userBean.user_name) &&
                Objects.equals(user_phone, userBean.user_phone) &&
                Objects.equals(user_pwd, userBean.user_pwd) &&
                Objects.equals(user_avatar, userBean.user_avatar) &&
                Objects.equals(user_birthday, userBean.user_birthday) &&
                Objects.equals(user_email, userBean.user_email) &&
                Objects.equals(user_introduced, userBean.user_introduced);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, user_name, user_phone, user_pwd, user_avatar, user_birthday, user_email, user_introduced);
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_phone='" + user_phone + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", user_birthday=" + user_birthday +
                ", user_email='" + user_email + '\'' +
                ", user_introduced='" + user_introduced + '\'' +
                '}';
    }

    public UserBean() {
    }

    public UserBean(String user_phone, String user_pwd) {
        this.user_phone = user_phone;
        this.user_pwd = user_pwd;
    }

    public UserBean(String user_name, String user_phone, String user_email, String user_pwd) {
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_email = user_email;
        this.user_pwd = user_pwd;
    }

    public UserBean(String user_name, String user_phone, String user_pwd, Date user_birthday, String user_email, String user_introduced) {
        this.user_name = user_name;
        this.user_phone = user_phone;
        this.user_pwd = user_pwd;
        this.user_birthday = user_birthday;
        this.user_email = user_email;
        this.user_introduced = user_introduced;
    }
}
