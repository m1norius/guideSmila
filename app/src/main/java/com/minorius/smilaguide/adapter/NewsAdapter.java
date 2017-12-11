package com.minorius.smilaguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.minorius.smilaguide.adapter.viewholder.BaseViewHolder;
import com.minorius.smilaguide.adapter.viewholder.NewsViewHolder;
import com.minorius.smilaguide.mvp.news.NewsPresenter;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.ArrayList;

/**
 * Created by minorius on 09.09.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private ArrayList<News> list;
    private NewsPresenter newsPresenter;
    View view;

    public NewsAdapter(ArrayList<News> list, NewsPresenter newsPresenter, View view) {
        this.list = list;
        this.newsPresenter = newsPresenter;
        this.view = view;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsViewHolder(parent, newsPresenter, view);
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
