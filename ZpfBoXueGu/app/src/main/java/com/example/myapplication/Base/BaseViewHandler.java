package com.example.myapplication.Base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class BaseViewHandler extends View {


    private LayoutInflater mInflater;
    private View contentView;
    private int layoutID;


    public BaseViewHandler(Context context, int layoutID) {
        super(context);

        mInflater=LayoutInflater.from(context);
        layoutID=layoutID;

        setup();
    }

    public BaseViewHandler(Context context) {
        super(context);

        mInflater=LayoutInflater.from(context);
        layoutID=0;

        setup();
    }

    protected void setup(){
        if (preferLayoutID() == 0){
            contentView=mInflater.inflate(layoutID,null);
        }else{
            contentView=mInflater.inflate(preferLayoutID(),null);
        }
    }

    protected int preferLayoutID(){
        return 0;
    }


    public View getContentView() {
        return contentView;
    }

    public void setContentView(View contentView) {
        this.contentView = contentView;
    }


}
