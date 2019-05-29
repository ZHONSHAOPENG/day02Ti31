package com.example.admin.day02ti3;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.admin.day02ti3.bean.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ViewPager mVp;
    /**
     * TextView
     */
    private TextView mTextView;
    private ArrayList<String> mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(MessageEvent messageEvent) {
        mUrl = messageEvent.getUrl();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTextView = (TextView) findViewById(R.id.textView);
        ArrayList<Integer> img = new ArrayList<>();
     //   new PagerAdapter();
    }
}
