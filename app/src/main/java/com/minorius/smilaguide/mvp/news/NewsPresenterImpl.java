package com.minorius.smilaguide.mvp.news;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.minorius.smilaguide.adapter.NewsAdapter;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.ArrayList;

/**
 * Created by minorius on 08.09.2017.
 */

public class NewsPresenterImpl extends MvpBasePresenter<NewsView> implements NewsPresenter {

    private NewsModel newsModel = new NewsModel();
    private ArrayList<News> updatedAllNewsList = new ArrayList<>();
    private Context context;

    private Runnable errorRunnable = () -> Toast.makeText(context, "Перевірте інтернет та спробуйте пізніше", Toast.LENGTH_SHORT).show();

    public NewsPresenterImpl(Context context) {
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void loadAllNews(String date) {
        Runnable runnable = () -> getView().showNews(newsModel.getList());
        newsModel.loadAllNews(runnable, date, errorRunnable);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void loadNewsByRegion(String region, String date) {
        Runnable runnable = () -> getView().showNews(newsModel.getList());
        newsModel.loadNewsByRegion(runnable, region, date, errorRunnable);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void loadNewsById(int id, View view) {

        Runnable runnable = () -> getView().showSelectedNews(newsModel.getDescription(), view);
        newsModel.loadNewsById(runnable, id, errorRunnable);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void updateAllNews(String date) {
        Runnable runnable = () -> {
            updatedAllNewsList.clear();
            updatedAllNewsList.addAll(newsModel.getList());
            getView().updateAllNews(updatedAllNewsList);
        };
        newsModel.loadAllNews(runnable, date, errorRunnable);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void updateRegionNews(String region, String date) {
        Runnable runnable = () -> {
            updatedAllNewsList.clear();
            updatedAllNewsList.addAll(newsModel.getList());
            getView().updateAllNews(updatedAllNewsList);
        };
        newsModel.loadNewsByRegion(runnable, region, date, errorRunnable);
    }
}
