package com.example.alexiaann.qqfragmentproject.View;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.alexiaann.qqfragmentproject.Constant;
import com.example.alexiaann.qqfragmentproject.R;

/**
 * Created by sks on 16/8/13.
 */
public class HeadControlPanel extends RelativeLayout {

    private Context context;
    private TextView middleTitle;
    private TextView rightTitle;
    private static final float middle_title_size = 20f;
    private static final float right_title_size = 17f;
    private static final int DEFAULT_BACKGROUND_COLOR = Color.rgb(23, 124, 202);

    public HeadControlPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        middleTitle = (TextView) findViewById(R.id.middle_title);
        rightTitle = (TextView) findViewById(R.id.right_title);
        setBackgroundColor(DEFAULT_BACKGROUND_COLOR);
        initHeadPanel();
    }

    public void initHeadPanel() {

        if (middleTitle != null) {
            setMiddleTitle(Constant.FRAGMENT_FLAG_MESSAGE);
        }
        if(rightTitle!=null){
            setRightTitle(Constant.FRAGMENT_RIGHT_TITLE);
        }

    }

    public void setMiddleTitle(String s) {

        middleTitle.setText(s);
        middleTitle.setTextSize(middle_title_size);

    }

    public void setRightTitle(String s){

        rightTitle.setText(s);
        rightTitle.setTextSize(right_title_size);

    }
}
