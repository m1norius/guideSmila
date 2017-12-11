package com.minorius.smilaguide.mvp.transport;

import android.widget.ProgressBar;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.minorius.smilaguide.adapter.pojo.transport.MarkerTransport;
import com.minorius.smilaguide.mvp.news.NewsView;

import java.util.ArrayList;

/**
 * Created by minorius on 13.09.2017.
 */

public interface TransportPresenter extends MvpPresenter<TransportView> {

    void getListSmilaBus();
    void getListOutSmilaBus();
    void getListCherkassySmila();
    void getListSmilaCherkassy();

    void getListTrainSmilaCherkassy();
    void getListTrainCherkassySmila();
}
