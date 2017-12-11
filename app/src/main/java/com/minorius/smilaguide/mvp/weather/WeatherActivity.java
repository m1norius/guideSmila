package com.minorius.smilaguide.mvp.weather;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.minorius.smilaguide.MainActivity;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.WeatherAdapter;
import com.minorius.smilaguide.adapter.pojo.weather.WeatherMarker;
import com.minorius.smilaguide.mvp.weather.WeatherPresenter;
import com.minorius.smilaguide.mvp.weather.WeatherPresenterImpl;
import com.minorius.smilaguide.mvp.weather.WeatherView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by minorius on 31.08.2017.
 */

public class WeatherActivity extends MvpActivity<WeatherView, WeatherPresenter> implements WeatherView  {

    public static final String BASE_URL_WEATHER = "https://api.openweathermap.org/";

    @BindView(R.id.id_recycler_weather)         RecyclerView recyclerView;
    @BindView(R.id.id_progress_bar_weather)     ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        if (MainActivity.isOnline()){
            getPresenter().loadWeather();
        }else {
            Toast.makeText(getApplicationContext(), "Інтернет відсутній", Toast.LENGTH_SHORT).show();
            finish();
        }

    }

    @NonNull
    @Override
    public WeatherPresenter createPresenter() {
        return new WeatherPresenterImpl();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void showWeather(ArrayList<WeatherMarker> list) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new WeatherAdapter(list, this));
    }
}
