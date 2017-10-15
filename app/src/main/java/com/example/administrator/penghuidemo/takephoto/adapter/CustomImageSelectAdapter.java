package com.example.administrator.penghuidemo.takephoto.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.chuangweixin.app.R;

import java.util.ArrayList;

import takephoto.model.Image;

/**
 * Created by Darshan on 4/18/2015.
 */
public class CustomImageSelectAdapter extends CustomGenericAdapter<Image> {
    public CustomImageSelectAdapter(Context context, ArrayList<Image> images) {
        super(context, images);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_view_item_image_select, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image_view_image_select);
            viewHolder.view = (CheckBox)convertView.findViewById(R.id.view_alpha);
            viewHolder.rlytcheck=(RelativeLayout)convertView.findViewById(R.id.rlyt_check);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView.getLayoutParams().width = size;
        viewHolder.imageView.getLayoutParams().height = size;
        if (arrayList.get(position).isSelected) {
            viewHolder.view.setChecked(true);
        } else {
            viewHolder.view.setChecked(false);
        }
        /*viewHolder.view.setOnClickListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (m_OnSelectPicListener!=null){
                    m_OnSelectPicListener.onSelectPic(position,isChecked);
                }
            }
        });*/
        viewHolder.rlytcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m_OnSelectPicListener!=null){
                    m_OnSelectPicListener.onSelectPic(position);
                }
            }
        });
        Glide.with(context)
                .load(arrayList.get(position).path)
                .placeholder(R.drawable.image_placeholder).into(viewHolder.imageView);
        return convertView;
    }

    private static class ViewHolder {
        public ImageView imageView;
        public CheckBox view;
        public RelativeLayout rlytcheck;
    }
    private OnSelectPicListener m_OnSelectPicListener;
    public void setOnShowPicClickListener(OnSelectPicListener Listener) {
        this.m_OnSelectPicListener = Listener;
    }
    /** 选择图片的监听*/
    public abstract interface  OnSelectPicListener {
        public abstract void onSelectPic(int position);
    }

}
