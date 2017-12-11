package com.minorius.smilaguide.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.minorius.smilaguide.adapter.viewholder.BaseViewHolder;
import com.minorius.smilaguide.adapter.viewholder.CategoryViewHolder;
import com.minorius.smilaguide.adapter.pojo.CategoryItem;

import java.util.ArrayList;

/**
 * Created by minorius on 29.08.2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    ArrayList<CategoryItem> objects;
    Context context;

    public CategoryAdapter(ArrayList<CategoryItem> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(objects.get(position));
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }
}

