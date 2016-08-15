package com.example.alexiaann.qqfragmentproject.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.alexiaann.qqfragmentproject.Constant.Constant;
import com.example.alexiaann.qqfragmentproject.MainActivity;
import com.example.alexiaann.qqfragmentproject.Adapter.MessageListAdapter;
import com.example.alexiaann.qqfragmentproject.Modal.MessageListModal;
import com.example.alexiaann.qqfragmentproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlexiaAnn on 2016/8/13 0013.
 */
public class MessageFragment extends BaseFragment {


    private ListView messageList = null;
    private MessageListAdapter listAdapter = null;
    private List<MessageListModal> lists = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lists = new ArrayList<MessageListModal>();
        lists.add(new MessageListModal(R.drawable.img_1,"小明","haha","明天"));
        lists.add(new MessageListModal(R.drawable.img_2,"小明","haha","明天"));
        lists.add(new MessageListModal(R.drawable.img_3,"小明","haha","明天"));
        lists.add(new MessageListModal(R.drawable.img_4,"小明","haha","明天"));
        lists.add(new MessageListModal(R.drawable.img_5,"小明","haha","明天"));

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.i("messagefragment","正在弄messagefragment");
        mFragmentManager = getActivity().getFragmentManager();
        View messageLayout = inflater.inflate(R.layout.message_layout,container,false);
        messageList = (ListView) messageLayout.findViewById(R.id.listview_message);
        listAdapter = new MessageListAdapter((MainActivity)getActivity(),lists);
        messageList.setAdapter(listAdapter);

        return messageLayout;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        MainActivity.currentFragmentTag = Constant.FRAGMENT_FLAG_MESSAGE;
    }
}
