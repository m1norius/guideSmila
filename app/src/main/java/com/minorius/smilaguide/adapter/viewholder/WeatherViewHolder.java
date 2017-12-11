package com.minorius.smilaguide.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.pojo.weather.WeatherItem;

import butterknife.BindView;

/**
 * Created by minorius on 31.08.2017.
 */

public class WeatherViewHolder extends BaseViewHolder<WeatherItem> {

    @BindView(R.id.id_txt_weather_temp) TextView temperature;
    @BindView(R.id.id_txt_weather_time) TextView time;
    @BindView(R.id.id_txt_weather_description) TextView description;
    @BindView(R.id.id_txt_weather_wind) TextView wind;
    @BindView(R.id.id_img_weather) ImageView weather;

    public WeatherViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_weather);
    }

    @Override
    protected void bindData(WeatherItem data) {
        temperature.setText(data.getTemperature());
        time.setText(data.getTime());
        wind.setText(data.getWind());
        description.setText(data.getDescription());

        int resId = getContext().getResources().getIdentifier(data.getImgUrl(), "drawable", getContext().getPackageName());
        weather.setImageResource(resId);
    }
}
