package com.minorius.smilaguide.retrofit.buy;

import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by minorius on 26.09.2017.
 */

public interface ApiBuyService {
    @POST("buy/topic")
    Observable<Void> sendOffer(@Body OfferForPurchase offerForPurchase);

    @GET("buy/get/{topic}")
    Observable<List<OfferForPurchase>> loadOffersByTopic(@Path("topic") String topic);

    @GET("buy/get/my/{email}")
    Observable<List<OfferForPurchase>> getUsersOffers(@Path("email") String email);

    @GET("buy/delete/{id}")
    Observable<Void> delById(@Path("id") int id);
}
