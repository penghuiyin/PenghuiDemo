package com.example.administrator.penghuidemo.tbdownactivity.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.penghuidemo.R;
import com.example.administrator.penghuidemo.tbdownactivity.TabDownActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class SelectLxFragment extends Fragment {

	private TabDownActivity m_Activity;
	/**
	 * 功能:选择项的列表
	 */
	private RecyclerView hv_mrxq_sxtj;
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
		initView(view);
		return view;
	}

	private void initView(View m_View) {
		//初始化recyclerview
		hv_mrxq_sxtj = (RecyclerView) m_View.findViewById(R.id.hv_mrxq_sxtj);
		LinearLayoutManager linearLayoutManager = new LinearLayoutManager(m_Activity);
		linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
		hv_mrxq_sxtj.setLayoutManager(linearLayoutManager);
	}

}
