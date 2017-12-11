package com.minorius.smilaguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.minorius.smilaguide.adapter.pojo.tv.TvGroup;
import com.minorius.smilaguide.adapter.viewholder.BaseViewHolder;
import com.minorius.smilaguide.adapter.viewholder.TvHorizontalRecyclerViewHolder;
import com.minorius.smilaguide.adapter.viewholder.TvGroupViewHolder;

import java.util.ArrayList;

/**
 * Created by minorius on 05.09.2017.
 */

public class TvAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    ArrayList<Object> list;

    public TvAdapter(ArrayList<Object> list) {
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        Object object = list.get(position);

        if (object instanceof TvGroup){
            return 1;
        }else if(object instanceof ArrayList){
            return 2;
        }



        return 202;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1){
            return new TvGroupViewHolder(parent);
        }
        return new TvHorizontalRecyclerViewHolder(parent);
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
