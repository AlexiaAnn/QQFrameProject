package com.example.alexiaann.qqfragmentproject.View;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.alexiaann.qqfragmentproject.Constant;
import com.example.alexiaann.qqfragmentproject.R;

import java.util.ArrayList;
import java.util.List;

/**ƒ
 * Created by sks on 16/8/13.
 */
public class BottomBarBtnPanel extends RelativeLayout implements View.OnClickListener {

    private Context mContext;
    private TabBarBtn mMsgBtn = null;
    private TabBarBtn mContactsBtn = null;
    private TabBarBtn mNewsBtn = null;
    private TabBarBtn mSettingBtn = null;
    private int DEFALUT_BACKGROUND_COLOR = Color.rgb(243, 243, 243); //Color.rgb(192, 192, 192)
    private BottomPanelCallback mBottomCallback = null;
    private List<TabBarBtn> viewList = new ArrayList<TabBarBtn>();

    public interface BottomPanelCallback{
        public void onBottomPanelClick(int itemId);
    }
    public BottomBarBtnPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //xml文件加载完后执行
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        mMsgBtn = (TabBarBtn) findViewById(R.id.bar1);
        mContactsBtn = (TabBarBtn)findViewById(R.id.bar2);
        mNewsBtn = (TabBarBtn)findViewById(R.id.bar3);
        mSettingBtn = (TabBarBtn)findViewById(R.id.bar4);
        setBackgroundColor(DEFALUT_BACKGROUND_COLOR);
        viewList.add(mMsgBtn);
        viewList.add(mContactsBtn);
        viewList.add(mNewsBtn);
        viewList.add(mSettingBtn);
        setBtnListener();
    }

    private void setBtnListener(){
        int num = this.getChildCount();
        for(int i = 0; i < num; i++){
            View v = getChildAt(i);
            if(v != null){
                v.setOnClickListener(this);
            }
        }
    }

    public void setBottomCallback(BottomPanelCallback bottomCallback){
        mBottomCallback = bottomCallback;
    }

    public void onClick(View v){

        for (TabBarBtn tabBarBtn:viewList){
            tabBarBtn.setDefaultImage();
        }

        int index = -1;
        switch (v.getId()){

            case R.id.bar1:
                index = Constant.BTN_FLAG_MESSAGE;
                mMsgBtn.setCheckedImage();
                break;
            case R.id.bar2:
                index = Constant.BTN_FLAG_CONTACTS;
                mContactsBtn.setCheckedImage();
                break;
            case R.id.bar3:
                index = Constant.BTN_FLAG_NEWS;
                mNewsBtn.setCheckedImage();
                break;
            case R.id.bar4:
                index = Constant.BTN_FLAG_SETTING;
                mSettingBtn.setCheckedImage();
                break;
            default:
                break;

        }
        if(mBottomCallback != null){
            mBottomCallback.onBottomPanelClick(index);
        }

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        layoutItems(l,t,r,b);
    }

    private void layoutItems(int left, int top, int right, int bottom){
        int n = getChildCount();
        if(n == 0){
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
//        Log.i("yanguoqi", "paddingLeft = " + paddingLeft + " paddingRight = " + paddingRight);
        int width = right - left;
        int height = bottom - top;
//        Log.i("yanguoqi", "width = " + width + " height = " + height);
        int allViewWidth = 0;
        for(int i = 0; i< n; i++){
            View v = getChildAt(i);
//            Log.i("yanguoqi", "v.getWidth() = " + v.getWidth());
            allViewWidth += v.getWidth();
        }
        int blankWidth = (width - allViewWidth - paddingLeft - paddingRight) / (n - 1);
//        Log.i("yanguoqi", "blankV = " + blankWidth );

        LayoutParams params1 = (LayoutParams) viewList.get(1).getLayoutParams();
        params1.leftMargin = blankWidth;
        viewList.get(1).setLayoutParams(params1);

        LayoutParams params2 = (LayoutParams) viewList.get(2).getLayoutParams();
        params2.leftMargin = blankWidth;
        viewList.get(2).setLayoutParams(params2);
    }
}
