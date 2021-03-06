package com.example.myapplication.Beans;

import org.litepal.crud.LitePalSupport;

public class UserInfoModel extends LitePalSupport {

    private String userName;
    private String password;
    private String nickName;
    private int id;




    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
