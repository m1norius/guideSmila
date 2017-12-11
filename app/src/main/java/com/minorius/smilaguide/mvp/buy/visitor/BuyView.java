package com.minorius.smilaguide.mvp.buy.visitor;

import com.hannesdorfmann.mosby3.mvp.MvpView;

import java.util.List;

/**
 * Created by minorius on 26.09.2017.
 */

public interface BuyView extends MvpView {

    void showRecyclerWithOffers(List list);
    void showProgressBar();
    void stopProgressBar();
    void showError();
}
