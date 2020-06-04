package com.example.myapplication.Modules.LoginRegist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.Base.BaseActivity;
import com.example.myapplication.R;

public class RegistActivity extends BaseActivity {


    private EditText userNameField,pswField,confirmPswField;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        TextView registBtn = (TextView)findViewById(R.id.registBtn);
        userNameField = findViewById(R.id.et_user_name);
        pswField = findViewById(R.id.et_password);
        confirmPswField = findViewById(R.id.confirm_password);

        registBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registAction();
            }
        });

    }

    private void registAction(){

        String name = userNameField.getText().toString();
        String psw = pswField.getText().toString();
        String confirmPsw = confirmPswField.getText().toString();

        if (name==null || name.length() == 0){
            showToast("用户名不能为空!");
            return;
        }

        if (psw==null || psw.length() == 0){
            showToast("密码不能为空!");
            return;
        }

        if (!psw.equals(confirmPsw)){
            showToast("密码不一致！");
            return;
        }

        try{
            LoginRegistHandler.registAction(name,psw);
        }catch (Exception e){

        }

    }



}
