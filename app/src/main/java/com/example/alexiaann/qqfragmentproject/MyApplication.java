package com.example.alexiaann.qqfragmentproject;

import android.app.Application;
import android.content.Context;

/**
 * Created by AlexiaAnn on 2016/8/13 0013.
 */
public class MyApplication extends Application {

    private static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
