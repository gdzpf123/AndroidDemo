package com.example.myapplication.Modules.Mine.Setting;


import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.myapplication.R;


import java.util.List;

public class SettingAdapter extends BaseMultiItemQuickAdapter<SettingItemModel, BaseViewHolder> {

    /**
     * 定义不同布局的类型ID
     */
    public static final int TYPE_HEAD = 0;
    public static final int TYPE_MIDDLE = 1;
//    public static final int TYPE_FOOT = 2;


    public SettingAdapter(List<SettingItemModel> data) {
        super(data);

        addItemType(TYPE_HEAD, R.layout.rec_header);
        addItemType(TYPE_MIDDLE, R.layout.setting_item_cell);
//        addItemType(TYPE_FOOT, R.layout.item3);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                itemClickAction(view,position);
            }
        });
    }

    @Override
    protected void convert(BaseViewHolder helper, SettingItemModel item) {
        switch (item.getItemType()){
            case TYPE_HEAD:


                break;

            case TYPE_MIDDLE:
                helper.setText(R.id.settingTextLab,item.getText());
                int index = getData().indexOf(item);
                int totalCount = getData().size();

                View bottomLine = helper.itemView.findViewById(R.id.bottomLine);
                if (index == (totalCount-1) || getData().get(index+1).getType() ==TYPE_HEAD ){
                    bottomLine.setVisibility(View.GONE);
                }else{
                    bottomLine.setVisibility(View.VISIBLE);
                }

                break ;

                default:

                    break;
        }
    }
    
    private void itemClickAction(View view, int position){

    }



}
