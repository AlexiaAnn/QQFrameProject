package com.example.alexiaann.qqfragmentproject.Fragment;

import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.alexiaann.qqfragmentproject.Constant;
import com.example.alexiaann.qqfragmentproject.MainActivity;
import com.example.alexiaann.qqfragmentproject.MyApplication;
import com.example.alexiaann.qqfragmentproject.R;
import com.example.alexiaann.qqfragmentproject.Transform.DepthPageTransformer;
import com.example.alexiaann.qqfragmentproject.Transform.RotateDownTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sks on 16/8/15.
 */
public class NewsFragment extends BaseFragment {

    private int[] imageId;
    private String[] titles;
    private List<ImageView> lists ;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        imageId =new  int[]{R.drawable.image1,R.drawable.image2,R.drawable.image3, R.drawable.image4};
        titles = new String[]{"image1","image2","image3","image4"};
        lists = new ArrayList<ImageView>();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View manageView = inflater.inflate(R.layout.new_layout,container,false);
        viewPager = (ViewPager) manageView.findViewById(R.id.viewPager);
        viewPager.setPageTransformer(true,new RotateDownTransformer());
        viewPager.setAdapter(new PagerAdapter() {

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                ImageView imageView = new ImageView(activity);
                imageView.setImageResource(imageId[position]);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                container.addView(imageView);
                lists.add(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {


                container.removeView(lists.get(position));
            }

            @Override
            public int getCount() {
                return imageId.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        });

        return manageView;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        MainActivity.currentFragmentTag = Constant.FRAGMENT_FLAG_NEWS;
    }
}
