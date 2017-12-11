package com.minorius.smilaguide.mvp.tv;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;

/**
 * Created by minorius on 05.09.2017.
 */

public interface TvPresenter extends MvpPresenter<TvView> {
    void loadTv();
}
