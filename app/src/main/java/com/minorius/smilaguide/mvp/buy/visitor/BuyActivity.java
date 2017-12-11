package com.minorius.smilaguide.mvp.buy.visitor;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.minorius.smilaguide.MainActivity;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.BuyAdapter;
import com.minorius.smilaguide.adapter.NewsAdapter;
import com.minorius.smilaguide.mvp.buy.vendor.LoginActivity;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;
import com.minorius.smilaguide.retrofit.weather.pojo.Main;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by minorius on 26.09.2017.
 */

public class BuyActivity extends MvpActivity<BuyView, BuyPresenter> implements BuyView {

    @BindView(R.id.id_button_buy_create)        ImageButton button;
    @BindView(R.id.id_recycler_buy)             RecyclerView recyclerView;
    @BindView(R.id.id_radio_group_buy)          RadioGroup radioGroup;
    @BindView(R.id.id_progress_bar_buy)         ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            View radioButton = group.findViewById(checkedId);
            int index = group.indexOfChild(radioButton);

            RadioButton r = (RadioButton) group.getChildAt(index);
            String tag = r.getTag().toString();

            getPresenter().loadOffersByTopic(tag);
        });

        getPresenter().loadOffersByTopic("pc");
    }

    @Override
    public void showRecyclerWithOffers(List list) {
        RecyclerView.Adapter adapter = new BuyAdapter(list);
        recyclerView.setAdapter(adapter);
        stopProgressBar();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError() {
        if (!MainActivity.isOnline()){
            Snackbar.make(recyclerView, "Інтернет відсутній", Snackbar.LENGTH_SHORT).show();
            stopProgressBar();
        } else {
            Snackbar.make(recyclerView, "Проблема з сервером", Snackbar.LENGTH_SHORT).show();
            stopProgressBar();
        }
    }


    @OnClick(R.id.id_button_buy_create)
    public void onClick() {
        startActivity(new Intent(BuyActivity.this, LoginActivity.class));
    }

    @NonNull
    @Override
    public BuyPresenter createPresenter() {
        return new BuyPresenterImpl();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        super.onBackPressed();
    }
}
