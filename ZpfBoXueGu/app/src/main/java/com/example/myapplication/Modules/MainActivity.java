package com.example.myapplication.Modules;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.myapplication.Base.BaseActivity;
import com.example.myapplication.Modules.Mine.MineViewHandler;
import com.example.myapplication.R;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static MainActivity shareInstance;


    public static void openActivity(Class activityClass){
        getInstance().pushActivity(activityClass);
    }

    private static void setInstance(MainActivity activity){
        shareInstance = activity;
    }

    public static MainActivity getInstance(){
        return shareInstance;
    }

    FrameLayout main_body;

    MineViewHandler mineViewHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.setInstance(this);
    }

    @Override
    protected int preferLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupUI() {
        super.setupUI();

        View courseBtn = findViewById(R.id.bottom_bar_course_btn);
        View exerciseBtn = findViewById(R.id.bottom_bar_exercises_btn);
        View mineBtn = findViewById(R.id.bottom_bar_myinfo_btn);

        main_body = findViewById(R.id.main_body);


        courseBtn.setOnClickListener(this);
        exerciseBtn.setOnClickListener(this);
        mineBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        View subView = null;
        switch (v.getId()){
            case R.id.bottom_bar_course_btn:

                break;
            case R.id.bottom_bar_exercises_btn:

                break;
            case R.id.bottom_bar_myinfo_btn:
                subView = getMineViewHandler().getContentView();
                break;

                default:

                    break;

        }

        if (subView != null){
            main_body.addView(subView);
        }

    }



    //Lazy


    public MineViewHandler getMineViewHandler() {
        if (mineViewHandler == null){
            mineViewHandler = new MineViewHandler(this);
        }

        return mineViewHandler;
    }
}
