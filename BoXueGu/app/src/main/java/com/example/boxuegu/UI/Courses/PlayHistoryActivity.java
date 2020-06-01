package com.example.boxuegu.UI.Courses;


import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boxuegu.Bean.VideoBean;
import com.example.boxuegu.R;
import com.example.boxuegu.Sqlite.DBUtils;
import com.example.boxuegu.UI.Adapter.PlayHistoryAdapter;
import com.example.boxuegu.Utils.AnalysisUtils;

import java.util.ArrayList;
import java.util.List;


public class PlayHistoryActivity extends AppCompatActivity {
    private TextView tv_main_title, tv_back, tv_none;
    private RelativeLayout rl_title_bar;
    private ListView lv_list;
    private PlayHistoryAdapter adapter;
    private List<VideoBean> vbl;
    private DBUtils db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_history);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        db=DBUtils.getInstance(this);
        vbl=new ArrayList<VideoBean>();
        vbl=db.getVideoHistory(AnalysisUtils.readLoginUserName(this));
        init();
    }

    private void init(){
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        tv_main_title.setText("播放记录");
        rl_title_bar = (RelativeLayout) findViewById(R.id.title_bar);
        rl_title_bar.setBackgroundColor(Color.parseColor("#30B4ff"));
        tv_back = (TextView) findViewById(R.id.tv_back);
        lv_list = (ListView) findViewById(R.id.lv_list);
        tv_none = (TextView) findViewById(R.id.tv_none);
        if (vbl.size()==0){
            tv_none.setVisibility(View.VISIBLE);
        }
        adapter=new PlayHistoryAdapter(this);
        adapter.setData(vbl);
        lv_list.setAdapter(adapter);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayHistoryActivity.this.finish();
                PlayHistoryActivity.this.finish();
            }
        });
    }
}