package com.minorius.smilaguide.mvp.buy.visitor;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

/**
 * Created by minorius on 26.09.2017.
 */

public interface BuyPresenter extends MvpPresenter<BuyView> {

    void loadOffersByTopic(String topic);
    void saveOffer(OfferForPurchase offerForPurchase, Runnable runnable, Runnable error);
}
