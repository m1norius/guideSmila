package com.minorius.smilaguide.mvp.weather;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.minorius.smilaguide.adapter.pojo.weather.WeatherMarker;

import java.util.ArrayList;

/**
 * Created by minorius on 31.08.2017.
 */

public interface WeatherView extends MvpView {
    void showWeather(ArrayList<WeatherMarker> list);
}
