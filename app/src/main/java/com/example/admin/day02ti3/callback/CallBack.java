package com.example.admin.day02ti3.callback;

import com.example.admin.day02ti3.bean.Bean;

public interface CallBack {
    void onSuccess(Bean bean);
    void onFail(String error);
}
