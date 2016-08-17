package com.example.alexiaann.qqfragmentproject;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.alexiaann.qqfragmentproject.Fragment.BaseFragment;
import com.example.alexiaann.qqfragmentproject.View.BottomBarBtnPanel;
import com.example.alexiaann.qqfragmentproject.View.HeadControlPanel;

public class MainActivity extends Activity implements BottomBarBtnPanel.BottomPanelCallback {

    private BottomBarBtnPanel bottomBarBtnPanel = null;
    private HeadControlPanel headControlPanel = null;

    private FragmentManager fragmentManager = null;
    //对fragment进行添加移除替换
    private FragmentTransaction fragmentTransaction = null;

    public static String currentFragmentTag = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomBarBtnPanel = (BottomBarBtnPanel) findViewById(R.id.bottom_layout);
        headControlPanel = (HeadControlPanel) findViewById(R.id.head_layout);
        fragmentManager = getFragmentManager();

        setDefaultFirstFragment(Constant.FRAGMENT_FLAG_MESSAGE);
        bottomBarBtnPanel.setBottomCallback(this);

    }

    @Override
    public void onBottomPanelClick(int itemId) {
        String tag = "";
        if((itemId & Constant.BTN_FLAG_MESSAGE) != 0){
            tag = Constant.FRAGMENT_FLAG_MESSAGE;
        }else if((itemId & Constant.BTN_FLAG_CONTACTS) != 0){
            tag = Constant.FRAGMENT_FLAG_CONTACTS;
        }else if((itemId & Constant.BTN_FLAG_NEWS) != 0){
            tag = Constant.FRAGMENT_FLAG_NEWS;
        }else if((itemId & Constant.BTN_FLAG_SETTING) != 0){
            tag = Constant.FRAGMENT_FLAG_SETTING;
        }

//        Toast.makeText(getApplicationContext(),tag,Toast.LENGTH_SHORT).show();
        setTabSelection(tag); //切换Fragment
        headControlPanel.setMiddleTitle(tag);//切换标题
    }

    //提交事务
    private void commitTransactions(String tag){
        if (fragmentTransaction != null && !fragmentTransaction.isEmpty()) {
            fragmentTransaction.commit();
            currentFragmentTag = tag;
            fragmentTransaction = null;
        }
    }

    private FragmentTransaction ensureTransaction( ){
        if(fragmentTransaction == null){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);

        }
        return fragmentTransaction;

    }


    private void attachFragment(int layout, Fragment f, String tag){
        if(f != null){
            if(f.isDetached()){
                ensureTransaction();
                fragmentTransaction.attach(f);

            }else if(!f.isAdded()){
                ensureTransaction();
                fragmentTransaction.add(layout, f, tag);
            }
        }
    }

    private Fragment getFragment(String tag){

        Fragment f = fragmentManager.findFragmentByTag(tag);

        if(f == null){
            Toast.makeText(getApplicationContext(), "fragment = null tag = " + tag, Toast.LENGTH_SHORT).show();
            f = BaseFragment.newInstance(tag);
            BaseFragment.activity = MainActivity.this;
        }
        return f;

    }

    private void detachFragment(Fragment f){

        if(f != null && !f.isDetached()){
            ensureTransaction();
            fragmentTransaction.detach(f);
        }
    }

    private  void switchFragment(String tag){
        if(TextUtils.equals(tag, currentFragmentTag)){
            return;
        }
        //把上一个fragment detach掉
        if(currentFragmentTag != null && !currentFragmentTag.equals("")){
            detachFragment(getFragment(currentFragmentTag));
        }
        attachFragment(R.id.fragment_content, getFragment(tag), tag);
        commitTransactions(tag);
    }

    public  void setTabSelection(String tag) {
        // 开启一个Fragment事务
        fragmentTransaction = fragmentManager.beginTransaction();

        switchFragment(tag);

    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        currentFragmentTag = "";
    }

    private void setDefaultFirstFragment(String tag){
//        Log.i("yan", "setDefaultFirstFragment enter... currFragTag = " + currFragTag);
        setTabSelection(tag);

//        Log.i("yan", "setDefaultFirstFragment exit...");
    }
}
