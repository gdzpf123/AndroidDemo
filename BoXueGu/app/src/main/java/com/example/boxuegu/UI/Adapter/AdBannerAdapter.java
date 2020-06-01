package com.example.boxuegu.UI.Adapter;


import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.boxuegu.Bean.CourseBean;
import com.example.boxuegu.UI.Courses.AdBeannerFragment;
import com.example.boxuegu.UI.Courses.CourseView;


public class AdBannerAdapter extends FragmentStatePagerAdapter implements View.OnTouchListener {
    private Handler mHandler;
    private List<CourseBean> cabl;
    public AdBannerAdapter(FragmentManager fm){
        super(fm);
        cabl = new ArrayList<CourseBean>();
    }
    public AdBannerAdapter(FragmentManager fm,Handler handler){
        super(fm);
        mHandler = handler;
        cabl = new ArrayList<CourseBean>();
    }

    //设置数据更新界面
    public void setDatas(List<CourseBean> cabl){
        this.cabl = cabl;
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int index) {
        Bundle args = new Bundle();
        if (cabl.size()>0)
            args.putString("ad",cabl.get(index%cabl.size()).icon);
        return AdBeannerFragment.newInstance(args);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    //返回数据集的真实容量大小
    public int getSize(){
        return cabl == null?0:cabl.size();
    }
    @Override
    public int getItemPosition(Object object){
        //防止刷新结果显示列表时出现缓存数据，重载这个函数，默认返回POSITION_NONE
        return POSITION_NONE;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        mHandler.removeMessages(CourseView.MSG_AD_SLID);
        return false;
    }
}

