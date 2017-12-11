package com.minorius.smilaguide.adapter.viewholder;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.BuyDeleteAdapter;
import com.minorius.smilaguide.mvp.buy.vendor.PopupBuy;
import com.minorius.smilaguide.retrofit.buy.RestBuy;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by minorius on 02.10.2017.
 */

public class BuyDeleteViewHolder extends BaseViewHolder<OfferForPurchase> {

    @BindView(R.id.id_txt_buy_title)            TextView title;
    @BindView(R.id.id_txt_buy_description)      TextView description;
    @BindView(R.id.id_txt_buy_price)            TextView price;
    @BindView(R.id.id_txt_buy_date)             TextView date;
    @BindView(R.id.id_image_button_buy_delete)  ImageButton delete;
    @BindView(R.id.id_progress_bar_buy_delete)  ProgressBar progressBar;

    private int id;
    private BuyDeleteAdapter adapter;
    private List list;
    private OfferForPurchase offerForPurchase;

    public BuyDeleteViewHolder(ViewGroup parent, BuyDeleteAdapter buyDeleteAdapter, List offersList) {
        super(parent, R.layout.item_buy_delete);
        this.adapter = buyDeleteAdapter;
        this.list = offersList;
    }

    @Override
    protected void bindData(OfferForPurchase data) {
        this.offerForPurchase = data;
        id = data.getId();
        title.setText(data.getTitle());
        description.setText(data.getDescription());
        price.setText(data.getPrice());
        title.setText(data.getTitle());
        String convertDate = data.getDate().replaceAll("-", ".").substring(0, 16);
        date.setText(convertDate);
    }

    @OnClick(R.id.id_image_button_buy_delete)
    public void onClick(){
        progressBar.setVisibility(View.VISIBLE);
        Log.d("QQQ", ""+id);
        RestBuy.get().delById(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aVoid -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    list.remove(offerForPurchase);
                    adapter.notifyItemRemoved(getAdapterPosition());
                    adapter.notifyItemRangeChanged(getAdapterPosition(),list.size());
                }, throwable -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    getContext().startActivity(new Intent(getContext(), PopupBuy.class).putExtra("KEY", "Помилка при видаленні повідомлення, перевірте інтернет та спробуйте пізніше"));
                });
    }
}
