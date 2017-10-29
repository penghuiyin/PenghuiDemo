package com.example.administrator.penghuidemo.View.tablewigit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sunger on 16/4/16.
 */
public class MaskView extends View {
    public MaskView(Context context) {
        this(context, null);
    }

    public MaskView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MaskView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public void show() {
        setVisibility(VISIBLE);
     }

    public void dissMiss() {
        setVisibility(GONE);
     }

}
