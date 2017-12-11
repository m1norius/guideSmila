package com.minorius.smilaguide.mvp.news.fragment;

import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.ArrayList;

/**
 * Created by minorius on 11.09.2017.
 */

public interface FragmentCommunicator {
    void updateRecycler(ArrayList<News> newses);
}
