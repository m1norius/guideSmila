package com.minorius.smilaguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.minorius.smilaguide.adapter.pojo.tv.TvChannel;
import com.minorius.smilaguide.adapter.pojo.tv.TvMarker;
import com.minorius.smilaguide.adapter.viewholder.BaseViewHolder;
import com.minorius.smilaguide.adapter.viewholder.TvChannelViewHolder;

import java.util.ArrayList;

/**
 * Created by minorius on 05.09.2017.
 */

public class ChannelAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    ArrayList<TvMarker> list;

    public ChannelAdapter(ArrayList<TvMarker> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        Object object = list.get(position);

        if (object instanceof TvChannel){
            return 1;
        }

        return 202;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TvChannelViewHolder(parent);
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
