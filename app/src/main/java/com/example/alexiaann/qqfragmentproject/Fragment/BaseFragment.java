package com.example.alexiaann.qqfragmentproject.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.text.TextUtils;

import com.example.alexiaann.qqfragmentproject.Constant;

/**
 * Created by AlexiaAnn on 2016/8/13 0013.
 */
public class BaseFragment extends android.app.Fragment {

    protected FragmentManager mFragmentManager = null;
    protected FragmentTransaction mFragmentTransaction = null;
    public static BaseFragment newInstance(String tag){
        BaseFragment baseFragment =  null;
//        if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_CONTACTS)){
//            baseFragment = new ContactsFragment();
//        }else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_MESSAGE)){
//            baseFragment = new MessageFragment();
//        }else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_NEWS)){
//            baseFragment = new NewsFragment();
//        }else if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_SETTING)){
//            baseFragment = new SettingFragment();
//        }

        if(TextUtils.equals(tag, Constant.FRAGMENT_FLAG_MESSAGE)){
            baseFragment = new MessageFragment();
        }

        return baseFragment;

    }
}
