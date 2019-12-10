package com.ys.demo.pojo;

import java.util.Date;

public class user {
    private String user_name;
    private int user_phone;
    private String user_pwd;
    private String user_avatar;
    private Date user_birthday;
    private String user_email;
    private String user_introduced;

    public user() {
        super();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String toString() {
        return "user{" +
                "user_name='" + user_name + '\'' +
                ", user_phone=" + user_phone +
                ", user_pwd='" + user_pwd + '\'' +
                ", user_avatar='" + user_avatar + '\'' +
                ", user_birthday=" + user_birthday +
                ", user_email='" + user_email + '\'' +
                ", user_introduced='" + user_introduced + '\'' +
                '}';
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(int user_phone) {
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
}
