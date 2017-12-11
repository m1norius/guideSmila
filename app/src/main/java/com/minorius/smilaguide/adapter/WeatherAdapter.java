package com.minorius.smilaguide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.minorius.smilaguide.adapter.pojo.weather.DayItem;
import com.minorius.smilaguide.adapter.pojo.weather.WeatherItem;
import com.minorius.smilaguide.adapter.pojo.weather.WeatherMarker;
import com.minorius.smilaguide.adapter.viewholder.BaseViewHolder;
import com.minorius.smilaguide.adapter.viewholder.DayWeatherViewHolder;
import com.minorius.smilaguide.adapter.viewholder.WeatherViewHolder;

import java.util.ArrayList;

/**
 * Created by minorius on 31.08.2017.
 */

public class WeatherAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    ArrayList<WeatherMarker> objects;
    Context context;

    public WeatherAdapter(ArrayList<WeatherMarker> objects, Context context) {
        this.objects = objects;
        this.context = context;

    }

    @Override
    public int getItemViewType(int position) {
        WeatherMarker weather = objects.get(position);

        if (weather instanceof DayItem){
            return 1;
        }else if(weather instanceof WeatherItem){
            return 2;
        }

        Log.d("QQQ", "202");
        return 202;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1){
            return new DayWeatherViewHolder(parent);
        }
        return new WeatherViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(objects.get(position));
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
}
