package com.example.alexiaann.qqfragmentproject.View;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.alexiaann.qqfragmentproject.R;

/**
 * Created by sks on 16/8/13.
 */
public class TabBarBtn extends LinearLayout {

    private Context context = null;
    private ImageView imageView = null;
    private TextView textView = null;

    private final static int DEFAULT_IMAGE_WIDTH = 64;
    private final static int DEFAULT_IMAGE_HEIGHT = 64;
    private int CHECKED_COLOR = Color.rgb(29, 118, 199);
    private int UNCHECKED_COLOR = Color.GRAY;

    public TabBarBtn(Context context) {
        super(context);
        context = context;
    }

    public TabBarBtn(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View parentView = inflater.inflate(R.layout.tabbar_btn, this, true);
        imageView = (ImageView) parentView.findViewById(R.id.imageView);
        textView = (TextView) parentView.findViewById(R.id.textView);

    }
}
