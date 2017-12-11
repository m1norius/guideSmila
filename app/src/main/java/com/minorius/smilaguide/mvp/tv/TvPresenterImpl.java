package com.minorius.smilaguide.mvp.tv;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

/**
 * Created by minorius on 05.09.2017.
 */

public class TvPresenterImpl extends MvpBasePresenter<TvView> implements TvPresenter {

    private TvModel tvModel = new TvModel();

    @Override
    public void loadTv() {
        getView().showTv(tvModel.getTvList());
    }
}
