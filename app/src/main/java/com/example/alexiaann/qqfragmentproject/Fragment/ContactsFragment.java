package com.example.alexiaann.qqfragmentproject.Fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.alexiaann.qqfragmentproject.Class.BlurBitmap;
import com.example.alexiaann.qqfragmentproject.R;

/**
 * Created by AlexiaAnn on 2016/8/16 0016.
 */
public class ContactsFragment extends BaseFragment{

    private ImageView fontImageView;
    private ImageView backImageView;
    private SeekBar seekBar;
    private int alpha;

    private Bitmap fontBitmap;
    private Bitmap backBitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fontBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);

        backBitmap = BlurBitmap.blur(BaseFragment.activity,fontBitmap);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.contacts_layout,container,false);
        fontImageView = (ImageView) v.findViewById(R.id.fontImageView);
        backImageView = (ImageView) v.findViewById(R.id.backImageView);

        fontImageView.setImageBitmap(fontBitmap);
        backImageView.setImageBitmap(backBitmap);
        seekBar = (SeekBar) v.findViewById(R.id.seekBar);

        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                alpha = i;
                fontImageView.setAlpha((int)(255 - alpha * 2.55));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return v;
    }
}
