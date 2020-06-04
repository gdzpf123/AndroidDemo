package com.example.myapplication.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myapplication.Beans.UserInfoModel;
import com.example.myapplication.ZpfApplication;

public class UserInfoManager {

    private static final String UserInfoKey = "UserInfoLocalKey";
    private static final String APPSharePreferenceKey = "appSharePreferenceKey";
    private static Context appContext = ZpfApplication.getContext();

    public static void setCurrentUserInfo(UserInfoModel userInfo){
        SharedPreferences mSharedPreferences = appContext.getSharedPreferences(APPSharePreferenceKey, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (userInfo == null){
            editor.remove(UserInfoKey);
        }else{
            String jsonStr = GsonUtils.toJson(userInfo);
            editor.putString("jaonStr",UserInfoKey);
        }

        editor.commit();
    }

    public static UserInfoModel getCurrentUserInfo(){
        SharedPreferences sp = appContext.getSharedPreferences(APPSharePreferenceKey, Context.MODE_PRIVATE);
        String jsonStr = sp.getString(UserInfoKey, "");
        if (jsonStr==null || jsonStr.length()==0){
            return null;
        }

        UserInfoModel userInfo = GsonUtils.fromJson(jsonStr,UserInfoModel.class);
        return userInfo;
    }




}
