package com.example.administrator.penghuidemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.example.administrator.penghuidemo.example.activty.TokoActivity;
import com.example.administrator.penghuidemo.example.activty.WeelActiviy;
import com.example.administrator.penghuidemo.tbdownactivity.TabDownActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton actv_toke_pice;
    private AppCompatButton actv_tabout,actv_btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inintView();
    }

    private void inintView() {
        actv_toke_pice=(AppCompatButton) findViewById(R.id.actv_toke_pice);
        actv_tabout=(AppCompatButton) findViewById(R.id.actv_tabout);
        actv_btn3=(AppCompatButton) findViewById(R.id.actv_btn3);
        actv_toke_pice.setOnClickListener(this);
        actv_tabout.setOnClickListener(this);
        actv_btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.actv_toke_pice:
                Intent in=new Intent(this, TokoActivity.class);
                startActivity(in);
                break;
            case R.id.actv_tabout:
                Intent in1=new Intent(this, TabDownActivity.class);
                startActivity(in1);
                break;
            case R.id.actv_btn3:
                Intent weel=new Intent(this, WeelActiviy.class);
                startActivity(weel);
                break;
        }
    }
}
