package com.minorius.smilaguide.mvp.buy.vendor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.google.firebase.auth.FirebaseAuth;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.BuyDeleteAdapter;
import com.minorius.smilaguide.mvp.buy.vendor.PopupBuy;
import com.minorius.smilaguide.retrofit.buy.RestBuy;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by minorius on 01.10.2017.
 */

public class FragmentDeleteBuy extends Fragment{

    @BindView(R.id.id_recycler_buy_delete) RecyclerView recyclerView;
    private FirebaseAuth firebaseAuth;
    private BuyDeleteAdapter buyDeleteAdapter;
    private List<OfferForPurchase> list;

    public static Fragment newInstance() {
        return new FragmentDeleteBuy();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buy_delete, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        firebaseAuth = FirebaseAuth.getInstance();

        RestBuy.get().getUsersOffers(firebaseAuth.getCurrentUser().getEmail())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    setList(data);
                    buyDeleteAdapter = new BuyDeleteAdapter(getList());
                    recyclerView.setAdapter(buyDeleteAdapter);

                }, Throwable::printStackTrace);


    }

    protected void loadOffersList(BuyActivityViewPager.TabAdapter tabAdapter){
        Log.d("QQQ", "+");

        RestBuy.get().getUsersOffers(firebaseAuth.getCurrentUser().getEmail())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(data -> {
                    Log.d("QQQ", ""+data);
                    setList(data);
                    tabAdapter.notifyDataSetChanged();
                }, Throwable::printStackTrace);

    }


    public List<OfferForPurchase> getList() {
        return list;
    }

    public void setList(List<OfferForPurchase> list) {
        this.list = list;
    }
}
