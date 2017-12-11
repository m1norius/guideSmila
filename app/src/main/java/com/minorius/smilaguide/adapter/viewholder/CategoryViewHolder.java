package com.minorius.smilaguide.adapter.viewholder;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minorius.smilaguide.mvp.buy.visitor.BuyActivity;
import com.minorius.smilaguide.mvp.news.NewsActivity;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.mvp.transport.TransportActivity;
import com.minorius.smilaguide.mvp.tv.TvActivity;
import com.minorius.smilaguide.mvp.weather.WeatherActivity;
import com.minorius.smilaguide.adapter.pojo.CategoryItem;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by minorius on 29.08.2017.
 */

public class CategoryViewHolder extends BaseViewHolder<CategoryItem> {

    @BindView(R.id.id_image_main) ImageView imageView;
    @BindView(R.id.id_txt_main) TextView textView;

    private CategoryItem categoryItem;

    public CategoryViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_groupe);
    }

    @Override
    protected void bindData(CategoryItem data) {
        this.categoryItem = data;
        String imageName = data.getImageName();
        int resId = getContext().getResources().getIdentifier(imageName, "drawable", getContext().getPackageName());
        textView.setText(data.getCategoryName());
        imageView.setImageResource(resId);

        if (categoryItem.getCategoryName().equals("Відпочинок") ||
            categoryItem.getCategoryName().equals("Термінали") ||
            categoryItem.getCategoryName().equals("Продам")){

                imageView.setAlpha(0.2f);
                textView.setAlpha(0.2f);
        }
    }

    @OnClick
    void onClick(){
        switch (categoryItem.getCategoryName()){
            case "Погода" :
                getContext().startActivity(new Intent(getContext(), WeatherActivity.class));
                break;
            case "McLaut TV" :
                getContext().startActivity(new Intent(getContext(), TvActivity.class));
                break;
            case "Новини" :
                getContext().startActivity(new Intent(getContext(), NewsActivity.class));
                break;
            case "Транспорт" :
                getContext().startActivity(new Intent(getContext(), TransportActivity.class));
                break;
            case "Куплю" :
                getContext().startActivity(new Intent(getContext(), BuyActivity.class));
                break;

        }
    }
}
