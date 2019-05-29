package com.example.admin.day02ti3.presenter;

import com.example.admin.day02ti3.bean.Bean;
import com.example.admin.day02ti3.callback.CallBack;
import com.example.admin.day02ti3.model.ModelFuli;
import com.example.admin.day02ti3.view.FuliView;

public class ImpPresenterFuli implements PresenterFuli, CallBack {

    private ModelFuli mModelFuli;
    private FuliView mMyView;

    public ImpPresenterFuli(ModelFuli modelFuli, FuliView myView) {
        mModelFuli = modelFuli;
        mMyView = myView;
    }

    @Override
    public void getData() {
        if (mModelFuli!=null){
            mModelFuli.getData(this);
        }
    }

    @Override
    public void onSuccess(Bean bean) {
        if (mMyView!=null){
            mMyView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String error) {
        if (mMyView!=null){
            mMyView.onFail(error);
        }
    }
}
