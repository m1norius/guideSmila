package com.minorius.smilaguide.mvp.transport;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.minorius.smilaguide.adapter.pojo.transport.MarkerTransport;

import java.util.ArrayList;

/**
 * Created by minorius on 13.09.2017.
 */

public interface TransportView extends MvpView {
    void showTransportBus(ArrayList<MarkerTransport> list);
    void showTransportTrain(ArrayList<MarkerTransport> list);
    void showProgressBar();
    void stopProgressBar();
}
