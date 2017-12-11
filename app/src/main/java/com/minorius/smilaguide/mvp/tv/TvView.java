package com.minorius.smilaguide.mvp.tv;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.minorius.smilaguide.adapter.pojo.tv.TvMarker;

import java.util.ArrayList;

/**
 * Created by minorius on 05.09.2017.
 */

public interface TvView extends MvpView {
    void showTv(ArrayList<Object> list);
}
