package com.minorius.smilaguide.mvp.weather;

import com.minorius.smilaguide.retrofit.weather.pojo.BaseWeather;
import android.icu.util.ULocale;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.minorius.smilaguide.adapter.pojo.weather.DayItem;
import com.minorius.smilaguide.adapter.pojo.weather.WeatherItem;
import com.minorius.smilaguide.adapter.pojo.weather.WeatherMarker;
import com.minorius.smilaguide.retrofit.weather.RestWeather;
import com.minorius.smilaguide.retrofit.weather.pojo.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by minorius on 31.08.2017.
 */

public class WeatherModel {
    private ArrayList<WeatherMarker> list = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void load(Runnable runnable){
        list.clear();
        RestWeather.call(RestWeather.get().getWeather(), data -> {
            parseWeather(data);
            runnable.run();
        });
    }

    public ArrayList<WeatherMarker> getList() {
        return list;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void parseWeather(BaseWeather data){

        String lastDate = "";

        for (List weatherItem : data.getList()){

            String newDate = weatherItem.getDtTxt().substring(0,11);

            if (lastDate.equals("") || !lastDate.equals(newDate)){
                lastDate = newDate;
                String dayOfWeek = firstUpperCase(convertUNIXTimeToRealDate(weatherItem.getDt()*1000-10800));
                list.add(new DayItem(lastDate.replaceAll("-","."), dayOfWeek));
            }

            addWeatherToList(weatherItem);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private String convertUNIXTimeToRealDate(long UNIXTime){

        Log.d("QQQ", ""+UNIXTime);
        ULocale uLocale = new ULocale("uk_UA");
        Date now = new Date(UNIXTime);
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE", uLocale.toLocale());

       return simpleDateformat.format(now);
    }

    private String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return "";
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

    private void addWeatherToList(List item){

        WeatherItem weatherItem = new WeatherItem();

        int temperature     =    (int) item.getMain().getTemp();
        int wind            =    (int) item.getWind().getSpeed();

        String time         =    item.getDtTxt().substring(11, 16);
        String description  =    item.getWeather().get(0).getDescription();
        String img          =    item.getWeather().get(0).getIcon();

        weatherItem.setTemperature(String.valueOf(temperature)+"°");
        weatherItem.setWind("Вітер "+String.valueOf(wind)+" м/с");
        weatherItem.setTime(time);
        weatherItem.setDescription(firstUpperCase(description));
        weatherItem.setImgUrl("icon"+img);

        list.add(weatherItem);
    }
}

