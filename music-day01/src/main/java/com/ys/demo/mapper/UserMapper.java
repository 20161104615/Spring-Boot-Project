package com.ys.demo.mapper;

import com.ys.demo.bean.UserBean;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    /**
     * 查找用户信息
     *      1、通过手机号或邮箱、用户密码查找用户，手机号和邮箱公用同一变量，用于验证用户登录信息
     *      2、通过手机号或邮箱查找用户，手机号和邮箱公用同一变量，用于判断用户是否重复、存在和获取修改后的用户信息
     *      3、接受String型name
     */
    // 1
    @Select("select * from user where (user_phone=#{user_phone} or user_email=#{user_phone}) and user_pwd=#{user_pwd}")
    public UserBean getUserByuser_phone(String user_phone, String user_pwd);

    // 2
    @Select("select * from user where user_phone=#{user_phone} or user_email=#{user_phone}")
    public UserBean finduser(UserBean userBean);

    //3
    @Select("select * from user where user_phone=#{userphone}")
    public UserBean finduserbystring(String userphone);

    @Select("select * from user where user_Administrator=#{userAdministrator}")
    public ArrayList<UserBean> findAllUser(boolean userAdministrator);

    @Select("SELECT * FROM user WHERE user_id <> #{user_id} " +
            "AND (user_phone = #{user_phone} OR user_email = #{user_email}) " +
            "AND user_Administrator = FALSE")
    public ArrayList<UserBean> FINDUSER(UserBean userBean);

    /**
     * 增加用户信心
     *      1、用户注册
     */
    @Insert("insert into user (user_name,user_phone,user_email,user_pwd) " +
            "values " +
            "(#{user_name},#{user_phone},#{user_email},#{user_pwd})")
    public int insertUser(UserBean userBean);

    /**
     * 修改用户信息
     *      1、用户修改，手机号和邮箱不允许修改
     *      2、管理员修改用户信息
     */
    @Update("update user set user_name=#{user_name},user_pwd=#{user_pwd}," +
            "user_birthday=#{user_birthday},user_introduced=#{user_introduced} where (user_phone=#{user_phone} or user_email=#{user_email})")
    public int updateuser(UserBean userBean);

    @Update("update user set user_name=#{user_name},user_pwd=#{user_pwd}," +
            "user_phone=#{user_phone},user_email=#{user_email},user_introduced=#{user_introduced} " +
            "where user_id=#{user_id} ")
    public boolean AUPDATEUSER(UserBean userBean);

    /**
     * 注销用户
     *      1、删除用户
     */
    @Delete("DELETE FROM user WHERE (user_phone=#{user_phone} or user_email=#{user_email})")
    public int deleteuser(UserBean userBean);

}
