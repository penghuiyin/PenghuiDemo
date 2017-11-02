package com.example.administrator.penghuidemo.example.activty;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.penghuidemo.R;
import com.example.administrator.penghuidemo.base.BaseActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import wheel.OnWheelChangedListener;
import wheel.WheelView;
import wheel.adapters.AddressTextAdapter;

/**
 * Created by My on 2017/11/2.
 * 滚轮选择的Activity
 */

public class WeelActiviy extends BaseActivity implements View.OnClickListener, OnWheelChangedListener {
    /**
     * 滚动选择的View
     */
    private LinearLayout llyt_wheelview;
    /**
     * 还款方式
     */
    private WheelView m_HkfsWheelView;
    //还款方式
    private String[] strHkfs = {"等额本息", "等额本金", "按期还息，到期还本"};

    /**
     * 滚动选择的View 添加rootView
     */
    private LinearLayout wheel_rootview;
    //取消
    private TextView tv_wheelcancel;
    //确定
    private TextView tv_wheelsure;
    private AppCompatButton acbtn1;
    private AddressTextAdapter provinceAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weel);
        inintView();
    }

    private void inintView() {
        llyt_wheelview = (LinearLayout) findViewById(R.id.llyt_wheelview);
        wheel_rootview = (LinearLayout) findViewById(R.id.wheel_rootview);
        tv_wheelcancel = (TextView)findViewById(R.id.tv_wheelcancel);
        tv_wheelsure = (TextView)findViewById(R.id.tv_wheelsure);
        acbtn1 = (AppCompatButton)findViewById(R.id.acbtn1);
        tv_wheelsure.setOnClickListener(this);
        tv_wheelcancel.setOnClickListener(this);
        acbtn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.acbtn1:
                llyt_wheelview.setVisibility(View.VISIBLE);
                createWheelView();
                break;
            case R.id.tv_wheelcancel:
                llyt_wheelview.setVisibility(View.GONE);
                break;
            case R.id.tv_wheelsure:
                llyt_wheelview.setVisibility(View.GONE);
                Toast.makeText(this, strHkfs[m_HkfsWheelView.getCurrentItem()], Toast.LENGTH_SHORT).show();
                break;
        }
    }
    private int maxsize = 20;
    private int minsize = 14;
    /**
     * 创建滚轮的view
     */
    private void createWheelView() {

        List<String> list = Arrays.asList(strHkfs);
        m_HkfsWheelView = new WheelView(this);
        provinceAdapter = new AddressTextAdapter(this, list, 1, maxsize, minsize);
        m_HkfsWheelView.setVisibleItems(3);
        m_HkfsWheelView.setViewAdapter(provinceAdapter);
        m_HkfsWheelView.setCurrentItem(1);
        // 添加change事件
        m_HkfsWheelView.addChangingListener(this);
        if (wheel_rootview.getChildCount() < 1) {
//            wheel_rootview.addView(loopView, layoutParams);
        } else {
            wheel_rootview.removeAllViews();

        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        wheel_rootview.addView(m_HkfsWheelView, layoutParams);
    }


    /**
     * Callback method to be invoked when current item changed
     *
     * @param wheel    the wheel view whose state has changed
     * @param oldValue the old value of current item
     * @param newValue the new value of current item
     */
    @Override
    public void onChanged(WheelView wheel, int oldValue, int newValue) {
        String currentText = (String) provinceAdapter.getItemText(wheel.getCurrentItem());
        setTextviewSize(currentText, provinceAdapter);
    }

    /**
     * 设置字体大小
     *
     * @param curriteItemText
     * @param adapter
     */
    public void setTextviewSize(String curriteItemText, AddressTextAdapter adapter) {
        ArrayList<View> arrayList = adapter.getTestViews();
        int size = arrayList.size();
        String currentText;
        for (int i = 0; i < size; i++) {
            TextView textvew = (TextView) arrayList.get(i);
            currentText = textvew.getText().toString();
            if (curriteItemText.equals(currentText)) {
                textvew.setTextSize(24);
            } else {
                textvew.setTextSize(14);
            }
        }
    }
}
