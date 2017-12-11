package com.minorius.smilaguide.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.mvp.news.NewsPresenter;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by minorius on 09.09.2017.
 */

public class NewsViewHolder extends BaseViewHolder<News> {

    @BindView(R.id.id_txt_news_title) TextView txtTitle;
    @BindView(R.id.id_txt_news_source) TextView txtSource;
    @BindView(R.id.id_txt_news_date) TextView txtDate;

    private News news;
    private NewsPresenter newsPresenter;
    View view;

    public NewsViewHolder(ViewGroup parent, NewsPresenter newsPresenter, View view) {
        super(parent, R.layout.item_news_title);
        this.newsPresenter = newsPresenter;
        this.view = view;
    }

    @Override
    protected void bindData(News data) {
        this.news = data;
        txtTitle.setText(data.getTitle());
        txtSource.setText(data.getSource());
        txtDate.setText(data.getDate().replaceAll("-", ".").substring(0, 16));
    }

    @OnClick
    public void onClick(){
        view.setVisibility(View.GONE);
        newsPresenter.loadNewsById(news.getId(), view);
    }

}
