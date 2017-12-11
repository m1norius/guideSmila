package com.minorius.smilaguide.adapter.viewholder;

import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.pojo.transport.DefaultPageTransport;

import butterknife.BindView;

/**
 * Created by minorius on 24.09.2017.
 */

public class DefaultPageViewHolder extends BaseViewHolder<DefaultPageTransport> {
    @BindView(R.id.id_txt_default_transport) TextView textView;

    public DefaultPageViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_default_transport);
    }

    @Override
    protected void bindData(DefaultPageTransport data) {
        textView.setText(data.getText());
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.textBackgroundButtonNews));
    }
}

