package com.example.myapplication;

import android.app.Application;
import android.content.Context;

public class ZpfApplication extends Application {


    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

<<<<<<< HEAD
=======
//        LitePal.initialize(this);
>>>>>>> 3884a903dbdf262f6e004b5ea16392c794bc519a

    }
    /**
     * 获取全局上下文*/
    public static Context getContext() {
        return context;
    }


}
