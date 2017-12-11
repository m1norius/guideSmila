package com.minorius.smilaguide.retrofit.weather;

import com.minorius.smilaguide.retrofit.weather.pojo.BaseWeather;

import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by minorius on 30.08.2017.
 */

public interface ApiWeatherService {
    @POST("data/2.5/forecast?id=693457&lang=ua&units=metric&APPID=1334f9d3a06a2c146e73a4d3a4830a3d")
    Observable<BaseWeather> getWeather();

}
