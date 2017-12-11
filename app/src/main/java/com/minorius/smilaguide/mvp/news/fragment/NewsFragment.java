package com.minorius.smilaguide.mvp.news.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.EndlessRecyclerViewScrollListener;
import com.minorius.smilaguide.adapter.NewsAdapter;
import com.minorius.smilaguide.mvp.news.NewsActivity;
import com.minorius.smilaguide.mvp.news.NewsPresenter;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.ArrayList;

/**
 * Created by minorius on 09.09.2017.
 */

public class NewsFragment extends Fragment {

    private EndlessRecyclerViewScrollListener scrollListener;
    private RecyclerView recyclerView;
    private NewsPresenter presenter;
    private NewsAdapter adapter;
    private ArrayList<News> list;
    private String region;
    private View view;

    public static Fragment newInstance(ArrayList list, String region) {

        Bundle arguments = new Bundle();
        arguments.putSerializable("LIST", list);
        arguments.putString("REGION", region);

        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((NewsActivity) getActivity()).setFragmentCommunicator(list -> {
            addToList(list);
            adapter.notifyDataSetChanged();
        });
        presenter = ((NewsActivity) getActivity()).getNewsPresenter();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        list = (ArrayList<News>) bundle.getSerializable("LIST");
        region = bundle.getString("REGION");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.id_recycler_news);
        LinearLayoutManager layoutManager = new LinearLayoutManager((getActivity()).getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NewsAdapter(list, presenter, view);
        recyclerView.setAdapter(adapter);

        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {

            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                String timeCodeForNextLoad = list.get(list.size() - 1).getDate();
                loadMore(timeCodeForNextLoad);
            }
        };
        recyclerView.addOnScrollListener(scrollListener);

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        recyclerView = null;
    }

    private void loadMore(String date) {
        if (region == null) {
            presenter.updateAllNews(date);
        } else {
            presenter.updateRegionNews(region, date);
        }
    }

    public void addToList(ArrayList<News> list) {
        this.list.addAll(list);
    }
}

