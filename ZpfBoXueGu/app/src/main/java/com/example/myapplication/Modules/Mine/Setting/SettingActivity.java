package com.example.myapplication.Modules.Mine.Setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
<<<<<<< HEAD
import android.widget.TextView;

import com.example.myapplication.Base.BaseActivity;
=======

>>>>>>> 3884a903dbdf262f6e004b5ea16392c794bc519a
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

<<<<<<< HEAD
public class SettingActivity extends BaseActivity {
=======
public class SettingActivity extends AppCompatActivity {
>>>>>>> 3884a903dbdf262f6e004b5ea16392c794bc519a


    private RecyclerView recyclerView;
    private List<SettingItemModel> datas;
    private SettingAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

<<<<<<< HEAD
//        setTitleString("设置");
//        TextView titleLab = findViewById(R.id.titleLab);
//        titleLab.setText("设置");

=======
>>>>>>> 3884a903dbdf262f6e004b5ea16392c794bc519a
        recyclerView=findViewById(R.id.recyelerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        initDAta();
        adapter = new SettingAdapter(datas);


        View header = getLayoutInflater().inflate(R.layout.rec_header, recyclerView, false);
        adapter.addHeaderView(header,2);


        recyclerView.setAdapter(adapter);


    }


    private void initDAta(){
        datas = new ArrayList<SettingItemModel>();
        String[] items = new String[]{"修改密码","设置密保","退出登录"};
        for (int i=0;i<items.length;i++){

            if (i==0 || i==2){
                SettingItemModel header = new SettingItemModel(SettingAdapter.TYPE_HEAD,"");
                datas.add(header);
            }

            SettingItemModel itemModel = new SettingItemModel(SettingAdapter.TYPE_MIDDLE,items[i]);
            datas.add(itemModel);

        }

    }


}

