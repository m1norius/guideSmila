package com.minorius.smilaguide.mvp.tv;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.TvAdapter;
import com.minorius.smilaguide.mvp.tv.TvPresenter;
import com.minorius.smilaguide.mvp.tv.TvPresenterImpl;
import com.minorius.smilaguide.mvp.tv.TvView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by minorius on 02.09.2017.
 */

public class TvActivity extends MvpActivity<TvView, TvPresenter> implements TvView {

    @BindView(R.id.id_recycler_tv) RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);
        ButterKnife.bind(this);
        getPresenter().loadTv();
    }

    @NonNull
    @Override
    public TvPresenter createPresenter() {
        return new TvPresenterImpl();
    }


    @Override
    public void showTv(ArrayList<Object> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new TvAdapter(list));
    }
}