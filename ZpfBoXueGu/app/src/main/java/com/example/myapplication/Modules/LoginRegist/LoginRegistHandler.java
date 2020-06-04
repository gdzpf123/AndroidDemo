package com.example.myapplication.Modules.LoginRegist;

import com.example.myapplication.Beans.UserInfoModel;

import org.litepal.LitePal;
import org.litepal.exceptions.DataSupportException;

import java.util.List;

public class LoginRegistHandler {

    public static void registAction(String name,String psw) throws Exception{

        UserInfoModel existUser = findUser(name);
        if (existUser != null){
            throw new Exception("用户已存在");

        }

        UserInfoModel user= new UserInfoModel();
        user.setUserName(name);
        user.setPassword(psw);
        user.setNickName(name);

        user.saveOrUpdate();

    }

    public static void loginAction(String name,String psw) throws Exception{
        UserInfoModel existUser = findUser(name);
        if (existUser == null){
            throw new Exception("用户不存在");
        }

        if (!psw.equals(existUser.getPassword())){
            throw new Exception("用户名密码错误");
        }

    }

    public static UserInfoModel findUser(String name){

       List<UserInfoModel> userList =  LitePal.where("userName = ?",name).find(UserInfoModel.class);
       if (userList!= null && userList.size()>0){
           return userList.get(0);
       }

       return null;
    }




}
