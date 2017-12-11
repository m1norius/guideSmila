package com.minorius.smilaguide.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.pojo.weather.DayItem;

import butterknife.BindView;

/**
 * Created by minorius on 01.09.2017.
 */

public class DayWeatherViewHolder extends BaseViewHolder<DayItem> {

    @BindView(R.id.id_txt_weather_day) TextView day;
    @BindView(R.id.id_txt_weather_week_day) TextView weekDay;

    public DayWeatherViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_weather_day);
    }

    @Override
    protected void bindData(DayItem data) {
        day.setText(data.getDay());
        weekDay.setText(data.getDayOfWeek());
    }
}
