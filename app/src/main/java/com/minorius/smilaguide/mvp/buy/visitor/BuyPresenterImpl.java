package com.minorius.smilaguide.mvp.buy.visitor;

import android.support.design.widget.Snackbar;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.minorius.smilaguide.MainActivity;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

/**
 * Created by minorius on 26.09.2017.
 */

public class BuyPresenterImpl extends MvpBasePresenter<BuyView> implements BuyPresenter {

    private BuyModel buyModel = new BuyModel();

    @Override
    public void loadOffersByTopic(String topic) {

        getView().showProgressBar();
        Runnable runnable = () -> getView().showRecyclerWithOffers(buyModel.getListOfferForPurchases());
        Runnable ifError = () -> getView().showError();
        buyModel.getOffersByTopic(topic, runnable, ifError);
    }

    @Override
    public void saveOffer(OfferForPurchase offerForPurchase, Runnable runnable, Runnable error) {
        buyModel.sendOffers(offerForPurchase, runnable, error);
    }
}
