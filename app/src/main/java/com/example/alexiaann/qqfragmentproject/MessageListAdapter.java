package com.example.alexiaann.qqfragmentproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alexiaann.qqfragmentproject.Modal.MessageListModal;

import java.util.List;

/**
 * Created by AlexiaAnn on 2016/8/13 0013.
 */
public class MessageListAdapter extends BaseAdapter {

//    private MainActivity activity = null;
    private List<MessageListModal> lists = null;
    private LayoutInflater inflater = null;

    public MessageListAdapter(Context context,List<MessageListModal> lists) {
        this.lists = lists;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = inflater.inflate(R.layout.message_list,null);

        ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
        imageView.setImageResource(lists.get(i).getImageResId());

        TextView userNameTextView = (TextView) v.findViewById(R.id.userNameTextView);
        userNameTextView.setText(lists.get(i).getUserName());

        TextView messageTextView = (TextView) v.findViewById(R.id.messageTextView);
        messageTextView.setText(lists.get(i).getMessage());

        TextView timeTextView = (TextView) v.findViewById(R.id.timeTextView);
        timeTextView.setText(lists.get(i).getTime());

        return v;
    }
}
