package com.example.administrator.penghuidemo.tbdownactivity.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.administrator.penghuidemo.R;
import com.example.administrator.penghuidemo.tbdownactivity.TabDownActivity;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class SelectDqFragment extends Fragment {

	private TabDownActivity m_Activity;
	//地区的二级列表
	private ExpandableListView m_ExpandableListView;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		this.m_Activity = (TabDownActivity) activity;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view= inflater.inflate(R.layout.layout_select_lx, null, false);
		return view;
	}

}
