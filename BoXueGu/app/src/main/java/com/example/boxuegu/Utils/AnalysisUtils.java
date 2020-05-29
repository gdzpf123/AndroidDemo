package com.example.boxuegu.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AnalysisUtils {

    /*
     * 从SharedPreferences中读取用户名
     */
    public static String readLoginUserName(Context context){
        SharedPreferences sp = context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        String userName = sp.getString("loginUserName","");
        return userName;
    }

}
