package com.example.administrator.penghuidemo.tbdownactivity;

import android.app.Fragment;
import android.os.Bundle;

import com.example.administrator.penghuidemo.R;
import com.example.administrator.penghuidemo.View.tablewigit.CommonTabLayout;
import com.example.administrator.penghuidemo.View.tablewigit.CustomTabEntity;
import com.example.administrator.penghuidemo.View.tablewigit.DropDownLayout;
import com.example.administrator.penghuidemo.View.tablewigit.MenuLayout;
import com.example.administrator.penghuidemo.View.tablewigit.OnMaskViewIsShowListener;
import com.example.administrator.penghuidemo.View.tablewigit.OnTabSelectListener;
import com.example.administrator.penghuidemo.View.tablewigit.TabEntity;
import com.example.administrator.penghuidemo.base.BaseActivity;
import com.example.administrator.penghuidemo.tbdownactivity.fragment.SelectDqFragment;
import com.example.administrator.penghuidemo.tbdownactivity.fragment.SelectLxFragment;
import com.example.administrator.penghuidemo.tbdownactivity.fragment.SelectZtFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/29.
 */
public class TabDownActivity extends BaseActivity implements OnMaskViewIsShowListener {
    private CommonTabLayout tabs;
    private String[] mTitles = {"地区", "状态", "类型"};
    private int[] mIconUnselectIds = {
            R.mipmap.icon_qyqh_arrow_down, R.mipmap.icon_qyqh_arrow_down,
            R.mipmap.icon_qyqh_arrow_down};
    private int[] mIconSelectIds = {
            R.mipmap.icon_qyqh_arrow_up, R.mipmap.icon_qyqh_arrow_up,
            R.mipmap.icon_qyqh_arrow_up};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private DropDownLayout dropDownLayout;
    private MenuLayout menuLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_foot);
        initTab();
    }

    private void initTab() {
        menuLayout = (MenuLayout) findViewById(R.id.menuLayout);
        dropDownLayout = (DropDownLayout) findViewById(R.id.dropdown);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new SelectDqFragment());
        fragments.add(new SelectZtFragment());
        fragments.add(new SelectLxFragment());
        menuLayout.setFragmentManager(getFragmentManager());
        menuLayout.bindFragments(fragments);
        tabs = (CommonTabLayout) findViewById(R.id.tabs);
        dropDownLayout.setOnMaskViewIsShowListener(this);
        updateTabData();

        tabs.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                tabs.setCurrentTab(position);
                dropDownLayout.showMenuAt(position);
            }

            @Override
            public void onTabReselect(int position) {
                if (menuLayout.isShow()) {
                    tabs.resetTabStyles();
                    dropDownLayout.closeMenu();
                } else {
                    tabs.setCurrentTab(position);
                    dropDownLayout.showMenuAt(position);
                }

            }
        });
    }
    private void updateTabData() {
        mTabEntities.clear();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabs.setTabData(mTabEntities);
    }
    @Override
    public void isClose(boolean isShow) {
        tabs.resetTabStyles();
    }
}
