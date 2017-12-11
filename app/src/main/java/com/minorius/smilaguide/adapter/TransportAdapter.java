package com.minorius.smilaguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.minorius.smilaguide.adapter.pojo.transport.Bus;
import com.minorius.smilaguide.adapter.pojo.transport.DefaultPageTransport;
import com.minorius.smilaguide.adapter.pojo.transport.ExtraBus;
import com.minorius.smilaguide.adapter.pojo.transport.MarkerTransport;
import com.minorius.smilaguide.adapter.pojo.transport.Train;
import com.minorius.smilaguide.adapter.viewholder.BaseViewHolder;
import com.minorius.smilaguide.adapter.viewholder.BusViewHolder;
import com.minorius.smilaguide.adapter.viewholder.DefaultPageViewHolder;
import com.minorius.smilaguide.adapter.viewholder.ExtraBusViewHolder;
import com.minorius.smilaguide.adapter.viewholder.TrainViewHolder;

import java.util.ArrayList;

/**
 * Created by minorius on 14.09.2017.
 */

public class TransportAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    ArrayList<MarkerTransport> list;

    public TransportAdapter(ArrayList<MarkerTransport> markerTransports) {
        this.list = markerTransports;
    }

    @Override
    public int getItemViewType(int position) {
        MarkerTransport item = list.get(position);
        if (item instanceof Bus)return 1;
        if (item instanceof ExtraBus)return 2;
        if (item instanceof Train)return 3;
        if (item instanceof DefaultPageTransport)return 4;
        return 202;
    }



        @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) return new BusViewHolder(parent);
        if (viewType == 2) return new ExtraBusViewHolder(parent);
        if (viewType == 3) return new TrainViewHolder(parent);
        if (viewType == 4) return new DefaultPageViewHolder(parent);

        return new BusViewHolder(parent);
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
