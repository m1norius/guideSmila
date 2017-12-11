package com.minorius.smilaguide.mvp.news;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.minorius.smilaguide.adapter.NewsAdapter;
import com.minorius.smilaguide.retrofit.news.pojo.Description;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by minorius on 08.09.2017.
 */

public interface NewsView extends MvpView {
    void showNews(List<News> list);
    void showSelectedNews(Description description, View view);
    void updateAllNews(ArrayList<News> newses);
}
