package com.example.admin.day02ti3;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.admin.day02ti3.adapter.MyVpAdapter;
import com.example.admin.day02ti3.adapter.RlvAdapter;
import com.example.admin.day02ti3.bean.Bean;
import com.example.admin.day02ti3.model.ImpModelFuli;
import com.example.admin.day02ti3.presenter.ImpPresenterFuli;
import com.example.admin.day02ti3.view.FuliView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

//1810A周少鹏
public class MainActivity extends AppCompatActivity implements FuliView {

    private RecyclerView mRlv;
    private ArrayList<Bean.ResultsBean> mList;
    private RlvAdapter mRlvAdapter;
    private ImpPresenterFuli mImpPresenterFuli;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImpPresenterFuli = new ImpPresenterFuli(new ImpModelFuli(), this);
        mImpPresenterFuli.getData();
        initView();
    }

    private void initView() {
        mRlv = (RecyclerView) findViewById(R.id.rlv);
        mVp = (ViewPager) findViewById(R.id.vp);
        mRlv.setLayoutManager(new LinearLayoutManager(this));
        mList = new ArrayList<>();
        mRlvAdapter = new RlvAdapter(this, mList);
        mRlv.setAdapter(mRlvAdapter);
        mRlvAdapter.setOnClickListener(new RlvAdapter.setOnClickListener() {
            @Override
            public void onClickListener(View v, int position, Bean.ResultsBean bean) {
                mRlv.setVisibility(View.GONE);
                mVp.setVisibility(View.VISIBLE);

                ArrayList<View> views = new ArrayList<>();
                for (int i = 0; i < mList.size(); i++) {

                    View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_vp, null);
                    ImageView mIv = view.findViewById(R.id.iv_vp);
                    TextView mTv = view.findViewById(R.id.tv_vp);

                    Glide.with(MainActivity.this).load(mList.get(position).getUrl())
                            .into(mIv);

                    mTv.setText(i + 1 + "/" + mList.size());

                    views.add(view);
                }


                MyVpAdapter myVpAdapter = new MyVpAdapter(views);
                mVp.setAdapter(myVpAdapter);
                myVpAdapter.notifyDataSetChanged();

                mVp.setCurrentItem(position);
            }


        });
    }

    @Override
    public void onSuccess(Bean bean) {
        if (bean != null) {
            mList.addAll(bean.getResults());
            mRlvAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFail(String error) {
        Log.d("tag", "onFail: " + error);
    }


}
