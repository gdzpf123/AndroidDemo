package com.example.myapplication.Base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> 3884a903dbdf262f6e004b5ea16392c794bc519a
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Beans.UserInfoModel;
import com.example.myapplication.Modules.LoginRegist.LoginActivity;
import com.example.myapplication.Utils.UserInfoManager;

import java.lang.reflect.Constructor;


public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(preferLayoutID());

        setupUI();

    }

    protected int preferLayoutID(){
        return 0;
    }

    protected void pushActivity(Class cls){
        Intent intent = new Intent(this,cls);
        startActivity(intent);
    }

    protected void setupUI(){

    }

<<<<<<< HEAD

=======
>>>>>>> 3884a903dbdf262f6e004b5ea16392c794bc519a
    protected void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    protected View getFrameViewFromLayout(int layoutResource){
        LayoutInflater mInflater = LayoutInflater.from(this);
        View view = mInflater.inflate(layoutResource,null);

        return view;
    }

    protected BaseViewHandler getFrameViewFromClass(Class viewCls){

        BaseViewHandler view = null;

        try{
            Constructor<BaseViewHandler> constructor = viewCls.getConstructor(viewCls);
            view = (BaseViewHandler) constructor.newInstance(this);
        }catch (Exception e){
            e.printStackTrace();
        }



        return view;

    }

    public Boolean checkLogin(){
        UserInfoModel userInfoModel = UserInfoManager.getCurrentUserInfo();
        if (userInfoModel == null){
            pushActivity(LoginActivity.class);
        }
        return userInfoModel!=null;
    }


    public void onActivityPopBack(Intent data)
    {

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onActivityPopBack(data);
    }
}


