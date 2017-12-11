package com.minorius.smilaguide.adapter.viewholder;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.pojo.transport.Bus;
import com.minorius.smilaguide.adapter.pojo.transport.MarkerTransport;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by minorius on 14.09.2017.
 */

public class BusViewHolder extends BaseViewHolder<Bus>{

    @BindView(R.id.id_txt_transport_title) TextView title;
    @BindView(R.id.id_txt_transport_description) TextView description;

    Bus bus;

    public BusViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_bus);
    }

    @Override
    protected void bindData(Bus data) {
        bus = data;
        title.setText(data.getTitle());
        if (data.getDescription().equals("")){
            description.setVisibility(View.GONE);
        }else {
            description.setText(data.getDescription());
        }
    }

    @OnClick
    public void onClick(){
        if (bus.getUrl()!=null){
            Log.d("QQQ", ""+bus.getUrl());
        }
    }
}
