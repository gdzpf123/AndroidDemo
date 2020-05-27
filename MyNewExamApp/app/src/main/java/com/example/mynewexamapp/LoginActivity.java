package com.example.mynewexamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynewexamapp.Dao.ExamDBHelper;
import com.example.mynewexamapp.Entity.UserModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private EditText nameField,PWDField;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nameField = findViewById(R.id.userNameField);
        PWDField = findViewById(R.id.userPwdField);
        checkBox = findViewById(R.id.checkBox);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
        refreshLoginInfo();
        try {
            copyDB();
        }catch (IOException e){

        }
    }

    private void loginAction()
    {
        String name = nameField.getText().toString();
        String pwd = PWDField.getText().toString();

        if (TextUtils.isEmpty(name)){
            showToast("用户名不能为空!");
            return;
        }

        if (TextUtils.isEmpty(pwd)){
            showToast("密码不能为空!");
            return;
        }

        UserModel user = ExamDBHelper.findUser(name,pwd);
        if (user == null){
            showToast("用户名或密码错误!");
            return;
        }

        showToast("登录成功");

        if (checkBox.isChecked()){
            saveLoginInfo();
        }else{
            cleanLoginInfo();
        }

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void refreshLoginInfo(){
        //读取缓存
        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        checkBox.setChecked(sharedPreferences.getBoolean("isCheck",false));
        nameField.setText(sharedPreferences.getString("userName",""));
        PWDField.setText(sharedPreferences.getString("userPwd",""));
    }

    private void saveLoginInfo(){
        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName",nameField.getText().toString());
        editor.putString("userPwd",PWDField.getText().toString());
        editor.putBoolean("isCheck",checkBox.isChecked());
        editor.commit();
    }

    private void cleanLoginInfo(){
        SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    //使用异步线程执行拷贝操作
    private boolean copyDB() throws IOException {
        File dbFile =  getDatabasePath("data.db3");
        if (!dbFile.exists()){
            //数据库不存在，则拷贝文件到目录
            Resources resources = getResources();
            InputStream inputStream = resources.openRawResource(R.raw.data);
            OutputStream outputStream = null;

            dbFile.createNewFile();
            outputStream = new FileOutputStream(dbFile);
            byte[] buf = new byte[1024];
            int len =0;
            while ( (len = inputStream.read(buf,0,1024) ) != -1){
                outputStream.write(buf,0,len);
            }
            inputStream.close();
            outputStream.close();
        }else{
            return false;
        }

        return true;
    }


    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        loginAction();
    }
}
