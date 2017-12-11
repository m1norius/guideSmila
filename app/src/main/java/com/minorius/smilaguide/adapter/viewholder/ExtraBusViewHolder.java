package com.minorius.smilaguide.adapter.viewholder;

import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.pojo.transport.ExtraBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by minorius on 15.09.2017.
 */

public class ExtraBusViewHolder extends BaseViewHolder<ExtraBus> {

    @BindView(R.id.id_txt_extra_bus_title) TextView title;
    @BindView(R.id.id_txt_extra_bus_description) TextView description;

    ExtraBus extraBus;

    public ExtraBusViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_extra_bus);
    }

    @Override
    protected void bindData(ExtraBus data) {
        extraBus = data;
        title.setText(data.getTitle());
        description.setText(data.getDescription());
    }

    @OnClick
    public void onClick(){
        if (extraBus.getUrl()!=null){

        }
    }
}
