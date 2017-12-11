package com.minorius.smilaguide.adapter.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

import butterknife.BindView;

/**
 * Created by minorius on 28.09.2017.
 */

public class BuyViewHolder extends BaseViewHolder<OfferForPurchase> {

    @BindView(R.id.id_txt_buy_title)        TextView title;
    @BindView(R.id.id_txt_buy_description)  TextView description;
    @BindView(R.id.id_txt_buy_date)         TextView date;
    @BindView(R.id.id_txt_buy_price)        TextView price;

    public BuyViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_buy);
    }

    @Override
    protected void bindData(OfferForPurchase data) {
        title.setText(data.getTitle());
        description.setText(data.getDescription());
        String convertDate = data.getDate().replaceAll("-", ".").substring(0, 16);
        date.setText(convertDate);
        price.setText(data.getPrice());
    }
}
