package com.minorius.smilaguide.adapter.viewholder;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minorius.smilaguide.mvp.tv.PlayTvActivity;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.pojo.tv.TvChannel;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by minorius on 05.09.2017.
 */

public class TvChannelViewHolder extends BaseViewHolder<TvChannel> {

    @BindView(R.id.id_img_channel) ImageView imageView;
    @BindView(R.id.id_txt_channel_title) TextView textView;

    private TvChannel tvChannel;

    public TvChannelViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_tv_channel);
    }

    @Override
    protected void bindData(TvChannel data) {
        this.tvChannel = data;

        textView.setText(data.getNameChannel());

        String imageName = data.getImg();
        int resId = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
        imageView.setImageResource(resId);

    }

    @OnClick
    public void onClick(){
        getContext().startActivity(new Intent(getContext(), PlayTvActivity.class).putExtra("url", tvChannel.getUrl()));
    }
}
