package com.minorius.smilaguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.minorius.smilaguide.adapter.viewholder.BaseViewHolder;
import com.minorius.smilaguide.adapter.viewholder.BuyViewHolder;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

import java.util.List;

/**
 * Created by minorius on 28.09.2017.
 */

public class BuyAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    List<OfferForPurchase> list;

    public BuyAdapter(List<OfferForPurchase> list) {
        this.list = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BuyViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
