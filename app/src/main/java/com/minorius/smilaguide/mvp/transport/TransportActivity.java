package com.minorius.smilaguide.mvp.transport;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.minorius.smilaguide.MainActivity;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.adapter.pojo.transport.DefaultPageTransport;
import com.minorius.smilaguide.adapter.pojo.transport.MarkerTransport;
import com.minorius.smilaguide.mvp.transport.fragment.TransportFragment;
import com.minorius.smilaguide.retrofit.weather.pojo.Main;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

/**
 * Created by minorius on 13.09.2017.
 */

public class TransportActivity extends MvpActivity<TransportView, TransportPresenter> implements TransportView{

    @BindView(R.id.id_tabs)                         TabLayout tabLayout;
    @BindView(R.id.id_app_bar)                      AppBarLayout appBarLayout;
    @BindView(R.id.id_view_pager)                   ViewPager viewPager;

    @BindView(R.id.id_radio_btn_city)               RadioButton btnCity;
    @BindView(R.id.id_radio_btn_out_city)           RadioButton btnOutCity;
    @BindView(R.id.id_radio_btn_smila_cherkassy)    RadioButton btnSmilaCherkassy;
    @BindView(R.id.id_radio_btn_cherkassy_smila)    RadioButton btnCherkassySmila;

    @BindView(R.id.id_radio_btn_train_smila_cherkassy) RadioButton btnTrainCherkassySmila;
    @BindView(R.id.id_radio_btn_train_cherkassy_smila) RadioButton btnTrainSmilaCherkassy;

    @BindView(R.id.id_radio_group_bus)              RadioGroup groupBus;
    @BindView(R.id.id_radio_group_train)            RadioGroup groupTrain;

    @BindView(R.id.id_progress_bar_transport) ProgressBar progressBar;

    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        ButterKnife.bind(this);


        tabAdapter = new TabAdapter(getSupportFragmentManager());
        getPresenter().getListSmilaBus();

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);
        addViewPagerListener();


    }

    private void addViewPagerListener(){
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        showGroup(groupBus, groupTrain);
                        break;
                    case 1:
                        showGroup(groupTrain, groupBus);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            private void showGroup(RadioGroup showGroup, RadioGroup goneGroup) {
                AlphaAnimation fadeIn = new AlphaAnimation(0.0f, 1.0f);
                fadeIn.setDuration(500);
                showGroup.startAnimation(fadeIn);

                goneGroup.setVisibility(View.GONE);
                showGroup.setVisibility(View.VISIBLE);
            }
        });
    }

    @OnClick({
            R.id.id_radio_btn_city,
            R.id.id_radio_btn_out_city,
            R.id.id_radio_btn_smila_cherkassy,
            R.id.id_radio_btn_cherkassy_smila})
    public void onClickBusGroup(View view){

        switch (view.getId()){
            case R.id.id_radio_btn_city :
                getPresenter().getListSmilaBus();
                break;
            case R.id.id_radio_btn_smila_cherkassy :
                getPresenter().getListSmilaCherkassy();
                break;
            case R.id.id_radio_btn_cherkassy_smila :
                getPresenter().getListCherkassySmila();
                break;
            case R.id.id_radio_btn_out_city :
                getPresenter().getListOutSmilaBus();
                break;
        }
    }

    @OnClick({
            R.id.id_radio_btn_train_smila_cherkassy,
            R.id.id_radio_btn_train_cherkassy_smila
    })
    public void onClickTrainGroup(View view){
//        if (!MainActivity.isOnline()){
//            Snackbar.make(viewPager, "Інтернет відсутній", Snackbar.LENGTH_SHORT).show();
//            return;
//        }

        switch (view.getId()){
            case R.id.id_radio_btn_train_smila_cherkassy :
                getPresenter().getListTrainSmilaCherkassy();

                break;
            case R.id.id_radio_btn_train_cherkassy_smila :
                getPresenter().getListTrainCherkassySmila();
                break;
        }
    }

    @NonNull
    @Override
    public TransportPresenter createPresenter() {
        return new TransportPresenterImpl();
    }

    @Override
    public void showTransportBus(ArrayList<MarkerTransport> list) {
        tabAdapter.setBus(list);
        tabAdapter.notifyDataSetChanged();
    }

    @Override
    public void showTransportTrain(ArrayList<MarkerTransport> list) {
        tabAdapter.setTrain(list);
        progressBar.setVisibility(View.INVISIBLE);
        tabAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    private class TabAdapter extends FragmentStatePagerAdapter {

        private ArrayList<MarkerTransport> bus = new ArrayList<>();
        private ArrayList<MarkerTransport> train = new ArrayList<>();

        private static final int TAB_COUNT = 2;

        TabAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public int getItemPosition(Object object) {
            return PagerAdapter.POSITION_NONE;
        }

        @Override
        public int getCount() {
            return TAB_COUNT;
        }


        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return TransportFragment.newInstance(bus);
                case 1:
                    if (train.size() == 0){
                        train.add(new DefaultPageTransport());
                    }
                    return TransportFragment.newInstance(train);
            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Автобус";
                case 1:
                    return "Поїзд";
            }
            return "Tab " + String.valueOf(position);
        }

        private void setBus(ArrayList<MarkerTransport> bus) {
            this.bus = bus;
        }

        private void setTrain(ArrayList<MarkerTransport> train) {
            this.train = train;
        }
    }
}
