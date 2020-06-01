package com.example.boxuegu.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {


    public static final int DB_VERSION = 1;  //数据库的版本
    public static final String DB_NAME = "wordpress.db";   //数据库的名称
    public static final String U_USERINFO = "userinfo";   //个人资料
    public SQLiteHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    //创建数据库
    @Override
    public void onCreate(SQLiteDatabase db){
        //创建用户信息表
        db.execSQL("CREATE TABLE IF NOT EXISTS " + U_USERINFO + "( " +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "userName VARCHAR,"  //用户名
                + "nickName VARCHAR,"  //昵称
                + "sex VARCHAR,"       //性别
                + "signature VARCHAR"  //签名
                + ")" );
    }

    //数据库升级 版本号增加 升级调用此方法
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF NOT EXISTS " + U_USERINFO);
        onCreate(db);

    }
}
