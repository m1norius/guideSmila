package com.minorius.smilaguide.mvp.weather;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by minorius on 31.08.2017.
 */

public interface WeatherPresenter extends MvpPresenter<WeatherView> {
    void loadWeather();
}
