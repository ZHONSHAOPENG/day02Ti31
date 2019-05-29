package com.example.admin.day02ti3.api;

import com.example.admin.day02ti3.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String url="http://gank.io/";

    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<Bean> getData();
}
