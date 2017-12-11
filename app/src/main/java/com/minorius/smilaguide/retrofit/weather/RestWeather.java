package com.minorius.smilaguide.retrofit.weather;

import com.minorius.smilaguide.mvp.weather.WeatherActivity;
import com.minorius.smilaguide.retrofit.weather.pojo.BaseWeather;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class RestWeather {

    public static ApiWeatherService get() {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(WeatherActivity.BASE_URL_WEATHER)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(ApiWeatherService.class);
    }

    public static <T extends BaseWeather> void call(Observable<T> observable, Action1<T> onComplete, Action1<Throwable> error) {

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onComplete, error);
    }

    public static <T extends BaseWeather> Observable<T> call(Observable<T> observable) {

        return observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public static <T extends BaseWeather> void call(Observable<T> observable, Action1<T> onComplete) {

        observable
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onComplete, throwable -> {
                });
    }
}
