package com.minorius.smilaguide.adapter.viewholder;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.ChannelAdapter;
import com.minorius.smilaguide.adapter.pojo.tv.TvMarker;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by minorius on 05.09.2017.
 */

public class TvHorizontalRecyclerViewHolder extends BaseViewHolder<ArrayList<TvMarker>> {
    
    @BindView(R.id.id_recycler_tv_horizontal) RecyclerView recyclerView;
    
    public TvHorizontalRecyclerViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_tv_horizontal_recycler);
    }

    @Override
    protected void bindData(ArrayList<TvMarker> data) {
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new ChannelAdapter(data));
    }
}
