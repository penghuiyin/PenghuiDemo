package com.example.administrator.penghuidemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;

import com.example.administrator.penghuidemo.example.activty.TokoActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatButton actv_toke_pice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inintView();
    }

    private void inintView() {
        actv_toke_pice=(AppCompatButton) findViewById(R.id.actv_toke_pice);
        actv_toke_pice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.actv_toke_pice:
                Intent in=new Intent(this, TokoActivity.class);
                startActivity(in);
                break;
        }
    }
}
