package com.minorius.smilaguide.mvp.weather;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by minorius on 31.08.2017.
 */

public class WeatherPresenterImpl extends MvpBasePresenter<WeatherView> implements WeatherPresenter {

    private WeatherModel weatherModel = new WeatherModel();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void loadWeather() {
        Runnable runnable = () -> getView().showWeather(weatherModel.getList());
        weatherModel.load(runnable);
    }
}
