package com.minorius.smilaguide.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.pojo.tv.TvGroup;

import butterknife.BindView;

/**
 * Created by minorius on 05.09.2017.
 */

public class TvGroupViewHolder extends BaseViewHolder<TvGroup> {

    @BindView(R.id.id_txt_tv_group) TextView textView;

    public TvGroupViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_tv_group);
    }

    @Override
    protected void bindData(TvGroup data) {
        textView.setText(data.getNameGroup());
    }
}
