package com.minorius.smilaguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.minorius.smilaguide.adapter.viewholder.BaseViewHolder;
import com.minorius.smilaguide.adapter.viewholder.BuyDeleteViewHolder;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

import java.util.List;

/**
 * Created by minorius on 02.10.2017.
 */

public class BuyDeleteAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    List<OfferForPurchase> list;

    public BuyDeleteAdapter(List<OfferForPurchase> list) {
        this.list = list;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BuyDeleteViewHolder(parent, this, list);
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
