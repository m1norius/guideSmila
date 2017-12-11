package com.minorius.smilaguide.mvp.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.NewsAdapter;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.ArrayList;

/**
 * Created by minorius on 10.09.2017.
 */

public class NewsDescription  extends Fragment {

    private TextView textView;
    static View view;

    public static Fragment newInstance(String description, View view){

        Bundle arguments = new Bundle();
        arguments.putString("DESCRIPTION", description);

        NewsDescription fragment = new NewsDescription();
        fragment.setArguments(arguments);
        NewsDescription.view = view;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_selected_news, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        textView = (TextView) view.findViewById(R.id.id_txt_news_description);

        Bundle bundle = getArguments();
        String description = bundle.getString("DESCRIPTION");

        textView.setText(description);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view.setVisibility(View.VISIBLE);
    }
}
