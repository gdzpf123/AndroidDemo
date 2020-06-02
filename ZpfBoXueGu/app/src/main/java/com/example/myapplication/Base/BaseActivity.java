package com.example.myapplication.Base;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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


    public void onActivityPopBack(Intent data)
    {

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        onActivityPopBack(data);
    }
}


