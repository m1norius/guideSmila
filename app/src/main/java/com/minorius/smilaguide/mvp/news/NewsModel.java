package com.minorius.smilaguide.mvp.news;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import com.minorius.smilaguide.retrofit.news.RestNews;
import com.minorius.smilaguide.retrofit.news.pojo.Description;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by minorius on 08.09.2017.
 */

public class NewsModel {

    private List<News> list;
    private Description description;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loadAllNews(Runnable runnable, String date, Runnable errorRunnable) {

        if (list != null) list.clear();

        RestNews.get()
                .loadNewsAll(date)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(obj -> {
                    list = obj;
                    runnable.run();
                }, throwable -> errorRunnable.run());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loadNewsByRegion(Runnable runnable, String region, String date, Runnable errorRunnable) {

        if (list != null) list.clear();

        RestNews.get()
                .loadNewsRegion(region, date)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(obj -> {
                    list = obj;
                    runnable.run();
                }, throwable -> errorRunnable.run());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loadNewsById(Runnable runnable, int id, Runnable errorRunnable) {

        RestNews.get()
                .loadNewsById(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(obj -> {
                    description = obj;
                    runnable.run();
                }, throwable -> errorRunnable.run());

    }

    public List<News> getList() {
        return list;
    }

    public Description getDescription() {
        return description;
    }
}
