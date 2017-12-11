package com.minorius.smilaguide.mvp.buy.vendor.fragment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.iid.FirebaseInstanceId;
import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.mvp.buy.vendor.PopupBuy;
import com.minorius.smilaguide.mvp.buy.visitor.BuyPresenter;
import com.minorius.smilaguide.mvp.buy.visitor.BuyPresenterImpl;
import com.minorius.smilaguide.mvp.buy.visitor.BuyView;
import com.minorius.smilaguide.retrofit.buy.pojo.OfferForPurchase;

import java.io.Serializable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by minorius on 01.10.2017.
 */

public class FragmentCreateBuy extends MvpFragment<BuyView, BuyPresenter> {

    @BindView(R.id.id_spinner_buy) Spinner spinner;
    @BindView(R.id.id_btn_buy_register) ImageButton registerBtn;
    @BindView(R.id.id_edit_text_buy_title) EditText title;
    @BindView(R.id.id_edit_text_buy_description) EditText description;
    @BindView(R.id.id_edit_text_buy_price) EditText price;
    @BindView(R.id.id_progress_bar_create_offer) ProgressBar progressBar;


    private FirebaseAuth firebaseAuth;

    private FragmentCommunicatorBuy fragmentCommunicatorBuy;

    public static Fragment newInstance() {
        return new FragmentCreateBuy();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            fragmentCommunicatorBuy = (FragmentCommunicatorBuy) getActivity();
        }catch (Exception e){
            Log.d("QQQ", "Check is activity impl");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buy_create, container, false);
    }

    @Override
    public BuyPresenter createPresenter() {
        return new BuyPresenterImpl();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);

        firebaseAuth = FirebaseAuth.getInstance();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.buy_topic, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @OnClick(R.id.id_btn_buy_register)
    public void onClick(View view) {

        int itemPosition = spinner.getSelectedItemPosition();
        String[] size_values = getResources().getStringArray(R.array.buy_topic_convert);
        String topic = size_values[itemPosition];

        String title = this.title.getText().toString();
        String description = this.description.getText().toString();
        String price = this.price.getText().toString();

        if (title.equals("") || description.equals("") || price.equals("")) {
            Snackbar.make(view, "Заповніть всі поля", Snackbar.LENGTH_SHORT).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        OfferForPurchase purchase = initOfferForBuy(topic, title, description, price);
        Runnable showPopup = () -> {
            fragmentCommunicatorBuy.updateRecycler();
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(new Intent(getActivity(), PopupBuy.class).putExtra("KEY", "Повідомлення успішно зареєстровано, через деякий час воно з'явиться в списку"));
        };
        Runnable showPopupError = () -> {
            progressBar.setVisibility(View.INVISIBLE);
            startActivity(new Intent(getActivity(), PopupBuy.class).putExtra("KEY", "Помилка при реєстрації повідомлення, перевірте інтернет та спробуйте пізніше"));
        };

        getPresenter().saveOffer(purchase, showPopup, showPopupError);

    }

    private OfferForPurchase initOfferForBuy(String topic, String title, String description, String price) {
        OfferForPurchase offerForPurchase = new OfferForPurchase();

        offerForPurchase.setTopic(topic);
        offerForPurchase.setTitle(title);
        offerForPurchase.setDescription(description);
        offerForPurchase.setPrice(price);
        offerForPurchase.setEmail(firebaseAuth.getCurrentUser().getEmail());
        offerForPurchase.setKey(FirebaseInstanceId.getInstance().getToken());

        offerForPurchase.setDate("");

        return offerForPurchase;
    }

    interface FragmentCommunicatorBuy {
        void updateRecycler();
    }
}
