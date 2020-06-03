package com.example.myapplication.Modules.Mine;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Base.BaseViewHandler;
import com.example.myapplication.Modules.Mine.Setting.SettingActivity;
import com.example.myapplication.R;

public class MineViewHandler extends BaseViewHandler implements View.OnClickListener {

    ImageView headImg;
    TextView nameLab;
    Context mContext;



    public MineViewHandler(Context context ) {
        super(context);
        mContext=context;
    }

    @Override
    protected int preferLayoutID() {
//        return super.preferLayoutID();
        return R.layout.mini_content_view;
    }

    @Override
    protected void setup() {
        super.setup();

        headImg=getContentView().findViewById(R.id.userHeadImg);
        nameLab=getContentView().findViewById(R.id.userNameLab);
        View playHis = getContentView().findViewById(R.id.playHistory);
        View setting = getContentView().findViewById(R.id.setting);


        playHis.setOnClickListener(this);
        setting.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playHistory:

                break;

            case R.id.setting:
                Intent intent = new Intent(mContext, SettingActivity.class);
                mContext.startActivity(intent);
                break;

                default:

                    break;
        }
    }

    private void openSetting(){

        Log.d("as", "openSetting: ");
    }

    private void openPlayHistory(){
        Log.d("as", "openPlayHistory: ");

    }


}
