package com.example.mynewexamapp.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.mynewexamapp.Entity.DBBase;
import com.example.mynewexamapp.Entity.QuestionModel;
import com.example.mynewexamapp.Entity.RadioModel;
import com.example.mynewexamapp.Entity.ToggleModel;
import com.example.mynewexamapp.Entity.UserModel;
import com.example.mynewexamapp.MyApplication;

import java.util.ArrayList;

public class ExamDBHelper extends SQLiteOpenHelper {

    private static  ExamDBHelper dbHelper;

    public static ExamDBHelper shareInstance(){
        if (dbHelper == null){
            dbHelper = new ExamDBHelper(MyApplication.getContext());
        }

        return dbHelper;
    }

    public ExamDBHelper(@Nullable Context context) {
        super(context, "data.db3", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //需要进行初始化的时候，执行响应的操作
        //如果数据库已经存在，则可以不需要执行响应的SQL语句
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public static int getCount(DBBase dbModel){
        String tableName = dbModel.getTableName();
        String sql = "select count(*) from "+tableName;
        Cursor cursor = ExamDBHelper.shareInstance().getReadableDatabase().rawQuery(sql, null);
        if (cursor != null && cursor.moveToNext()) {
            int count = cursor.getInt(0);
            return count;
        }
        return 0;    //无返回0
    }

    public static UserModel findUser(String userName , String userPwd)
    {
        SQLiteDatabase db = ExamDBHelper.shareInstance().getReadableDatabase();
        Cursor cursor = db.query("user", new String[]{"id", "userName", "userPwd"}, "userName=? AND userPwd=?", new String[]{userName, userPwd}, null, null, null);
        UserModel user = null;
        if (cursor != null && cursor.moveToNext()) {

            user = new UserModel();
            int index = cursor.getColumnIndex("id");
            int id = cursor.getInt(index);
            user.setId(id);

            index = cursor.getColumnIndex("userName");
            userName = cursor.getString(index);
            user.setName(userName);

            index = cursor.getColumnIndex("userPwd");
            userPwd = cursor.getString(index);
            user.setUserPwd(userPwd);
        }

        return user;
    }

    public static ArrayList<QuestionModel> findAll(QuestionModel model){
        String sql = "select * from " + model.getTableName();
        SQLiteDatabase db = ExamDBHelper.shareInstance().getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);

        ArrayList<QuestionModel> arr = new ArrayList<>();
        while (cursor.moveToNext()){
            if (model instanceof ToggleModel){
                ToggleModel toggle = new ToggleModel();
                toggle.setId(cursor.getInt(cursor.getColumnIndex("id")));
                toggle.setAns(cursor.getString(cursor.getColumnIndex("ans")));
                toggle.setTitle(cursor.getString(cursor.getColumnIndex("title")));

                arr.add(toggle);
            }else if (model instanceof RadioModel){
                RadioModel radio = new RadioModel();
                radio.setId(cursor.getInt(cursor.getColumnIndex("id")));
                radio.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                radio.setAns(cursor.getString(cursor.getColumnIndex("ans")));
                radio.setAnsA(cursor.getString(cursor.getColumnIndex("ansA")));
                radio.setAnsB(cursor.getString(cursor.getColumnIndex("ansB")));
                radio.setAnsC(cursor.getString(cursor.getColumnIndex("ansC")));
                radio.setAnsD(cursor.getString(cursor.getColumnIndex("ansD")));

                arr.add(radio);
            }
        }

        return arr;
    }

    public static QuestionModel findQuestion(QuestionModel model){
        int id = model.getId();
        String tableName = model.getTableName();
        String Sql = "select * from " + tableName + "where id = " + id;

        SQLiteDatabase db = ExamDBHelper.shareInstance().getReadableDatabase();
        Cursor cursor = db.rawQuery(Sql,null);

        if (cursor != null && cursor.moveToNext()) {
            if (model instanceof ToggleModel){
                ToggleModel toggle = new ToggleModel();
                toggle.setId(id);
                toggle.setAns(cursor.getString(cursor.getColumnIndex("ans")));
                toggle.setTitle(cursor.getString(cursor.getColumnIndex("title")));

                return toggle;
            }else if (model instanceof RadioModel){
                RadioModel radio = new RadioModel();
                radio.setId(id);
                radio.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                radio.setAns(cursor.getString(cursor.getColumnIndex("ans")));
                radio.setAnsA(cursor.getString(cursor.getColumnIndex("ansA")));
                radio.setAnsB(cursor.getString(cursor.getColumnIndex("ansB")));
                radio.setAnsC(cursor.getString(cursor.getColumnIndex("ansC")));
                radio.setAnsD(cursor.getString(cursor.getColumnIndex("ansD")));

                return radio;
            }else{
                return null;
            }

//            entity = new RadioEntity();
//            int index = cursor.getColumnIndex("id");
//            id = cursor.getInt(index);
//            entity.setId(id);
//
//            index = cursor.getColumnIndex("title");
//            String title = cursor.getString(index);
//            entity.setTitle(title);
//
//
//            index = cursor.getColumnIndex("ansA");
//            String ansA = cursor.getString(index);
//            entity.setAnsA(ansA);
//
//            index = cursor.getColumnIndex("ansB");
//            String ansB = cursor.getString(index);
//            entity.setAnsB(ansB);
//
//            index = cursor.getColumnIndex("ansC");
//            String ansC = cursor.getString(index);
//            entity.setAnsC(ansC);
//
//            index = cursor.getColumnIndex("ansD");
//            String ansD = cursor.getString(index);
//            entity.setAnsD(ansD);
//
//            index = cursor.getColumnIndex("ans");
//            String ans = cursor.getString(index);
//            entity.setAns(ans);
        }else{
            return null;
        }
    }




}
