package com.example.alexiaann.qqfragmentproject.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
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

    private int defaultImageId ;
    private int checkImageId;
    private String titleStr = "默认";

    private final static int DEFAULT_IMAGE_WIDTH = 64;
    private final static int DEFAULT_IMAGE_HEIGHT = 64;
    private int CHECKED_COLOR = Color.rgb(29, 118, 199);
    private int UNCHECKED_COLOR = Color.GRAY;

    //构造函数
    public TabBarBtn(Context context) {
        this(context,null);
        this.context = context;
    }
    public TabBarBtn(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        this.context = context;

        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View parentView = inflater.inflate(R.layout.tabbar_btn, this, true);
        imageView = (ImageView) parentView.findViewById(R.id.imageView);
        textView = (TextView) parentView.findViewById(R.id.textView);

    }
    public TabBarBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.context = context;
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View parentView = inflater.inflate(R.layout.tabbar_btn, this, true);
        imageView = (ImageView) parentView.findViewById(R.id.imageView);
        textView = (TextView) parentView.findViewById(R.id.textView);

        TypedArray array = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TabBarBtn, defStyleAttr, 0);
        int num = array.getIndexCount();
        for (int i = 0; i < num; i++) {

            int attr = array.getIndex(i);
            switch (attr) {

                case R.styleable.TabBarBtn_defaultImage:
                    defaultImageId = array.getResourceId(attr, R.drawable.img_5);
                    break;
                case R.styleable.TabBarBtn_checkedImage:
                    checkImageId = array.getResourceId(attr, R.drawable.img_5);
                    break;
                case R.styleable.TabBarBtn_titleStr:
                    titleStr = array.getString(attr);
                default:
                    break;
            }
        }
        array.recycle();

        setDefaultImage();
        setText();

    }

    //设置默认情况下的图片
    public void setDefaultImage(){
        setDefaultImage(defaultImageId);
    }
    public void setDefaultImage(int imageResourceId){

        if(imageView!=null){

            imageView.setImageResource(imageResourceId);
            setImageSize(DEFAULT_IMAGE_WIDTH,DEFAULT_IMAGE_HEIGHT);

        }

    }
    //设置选中情况下的图片
    public void setCheckedImage(){
        setCheckedImage(checkImageId);
    }
    public void setCheckedImage(int imageResourceId){

        if(imageView!=null){
            imageView.setImageResource(imageResourceId);
            setImageSize(DEFAULT_IMAGE_WIDTH,DEFAULT_IMAGE_HEIGHT);
        }
    }
    //设置imageview的尺寸
    public void setImageSize(int width,int height){

        if(imageView!=null){

            ViewGroup.LayoutParams params = imageView.getLayoutParams();
            params.width = width;
            params.height = height;
            imageView.setLayoutParams(params);

        }

    }
    //设置图片下方文本
    public void setText(){
        setText(titleStr);
    }
    public void setText(String str){
        if(textView!=null){

            textView.setText(str);
            textView.setTextColor(UNCHECKED_COLOR);

        }
    }
    public void setCheckedTextColor(){
        if(textView!=null){
            textView.setTextColor(CHECKED_COLOR);
        }
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//
//        int action = event.getAction();
//        if(action == MotionEvent.ACTION_DOWN){
//
//            setCheckedImage();
//            return true;
//        }
//        else if(action == MotionEvent.ACTION_UP){
//            setDefaultImage();
//            return true;
//        }
//        return super.onTouchEvent(event);
//    }
}
