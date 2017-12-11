package com.minorius.smilaguide.mvp.buy.visitor;

import android.util.Log;

import com.minorius.smilaguide.retrofit.buy.RestBuy;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by minorius on 26.09.2017.
 */

public class BuyModel {

    private List<OfferForPurchase> offerForPurchases;

    public void sendOffers(OfferForPurchase offerForPurchase, Runnable showPopup, Runnable error) {
        RestBuy.get().sendOffer(offerForPurchase)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aVoid -> showPopup.run(), throwable -> error.run());
    }

    public void getOffersByTopic(String topic, Runnable runnable, Runnable ifError) {
        RestBuy.get().loadOffersByTopic(topic)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    offerForPurchases = data;
                    runnable.run();
                }, throwable -> ifError.run());
    }

    public List<OfferForPurchase> getListOfferForPurchases() {
        return offerForPurchases;
    }
}
