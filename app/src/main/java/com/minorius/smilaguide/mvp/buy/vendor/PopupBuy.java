package com.minorius.smilaguide.mvp.buy.vendor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.minorius.smilaguide.R;
import com.minorius.smilaguide.mvp.buy.vendor.fragment.BuyActivityViewPager;
import com.minorius.smilaguide.mvp.buy.visitor.BuyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by minorius on 30.09.2017.
 */

public class PopupBuy extends Activity {

    @BindView(R.id.id_txt_popup)                    TextView textView;
    @BindView(R.id.id_btn_popup_buy_create_new)     Button createNew;
    @BindView(R.id.id_btn_popup_buy_back_to_list)   Button backToList;
    @BindView(R.id.id_btn_popup_buy_back_to_message)   Button backToMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_buy);

        ButterKnife.bind(PopupBuy.this);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        String text = getIntent().getStringExtra("KEY");
        textView.setText(text);
    }

    @OnClick({R.id.id_btn_popup_buy_create_new, R.id.id_btn_popup_buy_back_to_list, R.id.id_btn_popup_buy_back_to_message})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_btn_popup_buy_create_new:
                Intent intentCreateNew = new Intent(this, BuyActivityViewPager.class);
                intentCreateNew.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentCreateNew);
                break;
            case R.id.id_btn_popup_buy_back_to_list:
                Intent intentBackToList = new Intent(this, BuyActivity.class);
                intentBackToList.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentBackToList);
                break;
            case R.id.id_btn_popup_buy_back_to_message:
                finish();
                break;
        }
    }


    @Override
    public void onBackPressed() {
        Intent intentCreateNew = new Intent(this, BuyActivityViewPager.class);
        intentCreateNew.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intentCreateNew);
        super.onBackPressed();
    }
}

