package com.minorius.smilaguide.mvp.transport.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.NewsAdapter;
import com.minorius.smilaguide.adapter.TransportAdapter;
import com.minorius.smilaguide.adapter.pojo.transport.Bus;
import com.minorius.smilaguide.adapter.pojo.transport.MarkerTransport;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.ArrayList;

/**
 * Created by minorius on 14.09.2017.
 */

public class TransportFragment extends Fragment {

    ArrayList<MarkerTransport> list;

    public static Fragment newInstance(ArrayList<MarkerTransport> list){
        Bundle bundle = new Bundle();
        bundle.putSerializable("LIST", list);

        TransportFragment transportFragment = new TransportFragment();
        transportFragment.setArguments(bundle);

        return transportFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        list = (ArrayList<MarkerTransport>) bundle.getSerializable("LIST");
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_transport, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.id_recycler_transport);
        LinearLayoutManager layoutManager = new LinearLayoutManager((getActivity()).getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        TransportAdapter adapter = new TransportAdapter(list);
        recyclerView.setAdapter(adapter);

        super.onViewCreated(view, savedInstanceState);
    }
}
