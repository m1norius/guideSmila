package com.minorius.smilaguide.mvp.news;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.minorius.smilaguide.adapter.NewsAdapter;

/**
 * Created by minorius on 08.09.2017.
 */

public interface NewsPresenter extends MvpPresenter<NewsView> {
    void loadAllNews(String date);
    void loadNewsByRegion(String region, String date);
    void loadNewsById(int id, View view);
    void updateAllNews(String date);
    void updateRegionNews(String region, String date);
}
