package com.minorius.smilaguide.retrofit.news;

import com.minorius.smilaguide.MainActivity;
import com.minorius.smilaguide.mvp.news.NewsActivity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestNews {

    public static ApiNewsService get() {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        try {
            return new Retrofit.Builder()
                    .baseUrl(MainActivity.BASE_REST_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiNewsService.class);
        }catch (Exception e){
            return new Retrofit.Builder()
                    .baseUrl("http://0.0.0.0:8080")
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiNewsService.class);
        }
    }
}
