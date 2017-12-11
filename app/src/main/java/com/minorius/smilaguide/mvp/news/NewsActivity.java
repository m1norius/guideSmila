package com.minorius.smilaguide.mvp.news;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.minorius.smilaguide.MainActivity;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.mvp.news.fragment.FragmentCommunicator;
import com.minorius.smilaguide.mvp.news.fragment.FragmentNavigator;
import com.minorius.smilaguide.mvp.news.fragment.NewsDescription;
import com.minorius.smilaguide.mvp.news.fragment.NewsFragment;
import com.minorius.smilaguide.retrofit.news.pojo.Description;
import com.minorius.smilaguide.retrofit.news.pojo.News;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by minorius on 08.09.2017.
 */

public class NewsActivity extends MvpActivity<NewsView, NewsPresenter> implements NewsView {

    private FragmentNavigator fragmentNavigator;
    private NewsPresenter newsPresenter;
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private FragmentCommunicator fragmentCommunicator;

    private String region;

    public static final String APP_PREFERENCES = "subsettings";

    public String subscribeSmila        = "Smila";
    public String subscribeCherkassy    = "Cherkassy";
    public String subscribeUkraine      = "Ukraine";
    public String subscribeWorld        = "World";

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @BindView(R.id.id_down_item_smila)      RelativeLayout smilaDownItem;
    @BindView(R.id.id_down_item_cherkassy)  RelativeLayout cherkassyDownItem;
    @BindView(R.id.id_down_item_ukr)        RelativeLayout ukrDownItem;
    @BindView(R.id.id_down_item_world)      RelativeLayout worldDownItem;

    @BindView(R.id.id_check_box_smila_sub)      CheckBox smilaBox;
    @BindView(R.id.id_check_box_cherkassy_sub)  CheckBox cherkassyBox;
    @BindView(R.id.id_check_box_ukraine_sub)    CheckBox ukraineBox;
    @BindView(R.id.id_check_box_world_sub)      CheckBox worldBox;

    @BindView(R.id.id_progress_bar_news)        ProgressBar progressBar;
    @BindView(R.id.id_progress_bar_smila)        ProgressBar progressBarSmila;
    @BindView(R.id.id_progress_bar_cherkassy)        ProgressBar progressBarCherkassy;
    @BindView(R.id.id_progress_bar_ukraine)        ProgressBar progressBarUkraine;
    @BindView(R.id.id_progress_bar_world)        ProgressBar progressBarWorld;

    private ArrayList<News> newList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);

        Log.d("Firebase", "token "+ FirebaseInstanceId.getInstance().getToken());

        preferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        preferences = this.getPreferences(Context.MODE_PRIVATE);

        smilaBox.setChecked(preferences.getBoolean(subscribeSmila, false));
        cherkassyBox.setChecked(preferences.getBoolean(subscribeCherkassy, false));
        ukraineBox.setChecked(preferences.getBoolean(subscribeUkraine, false));
        worldBox.setChecked(preferences.getBoolean(subscribeWorld, false));

        fragmentNavigator = new FragmentNavigator(R.id.id_frame_news, fragmentManager);

        newsPresenter = getPresenter();

        if (MainActivity.isOnline()){
            newsPresenter.loadAllNews("");
        }else {
            Snackbar.make(progressBar, "Інтернет відсутній", Snackbar.LENGTH_SHORT).show();
        }

    }

    @OnClick({
            R.id.id_check_box_smila_sub,
            R.id.id_check_box_cherkassy_sub,
            R.id.id_check_box_ukraine_sub,
            R.id.id_check_box_world_sub
    })
    public void onClickBox(View view){


            switch (view.getId()){
                case R.id.id_check_box_smila_sub :
                    subscribe(smilaBox, subscribeSmila);
                    break;
                case R.id.id_check_box_cherkassy_sub :
                    subscribe(cherkassyBox, subscribeCherkassy);
                    break;
                case R.id.id_check_box_ukraine_sub :
                    subscribe(ukraineBox, subscribeUkraine);
                    break;
                case R.id.id_check_box_world_sub :
                    subscribe(worldBox, subscribeWorld);
                    break;
            }


    }

    private void subscribe(CheckBox box, String topic){
        editor = preferences.edit();

        if (box.isChecked()){
            FirebaseMessaging.getInstance().subscribeToTopic(topic);
        }else {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(topic);
        }
        editor.putBoolean(topic, box.isChecked());
        editor.apply();
    }


    @OnClick({
            R.id.id_down_item_smila,
            R.id.id_down_item_cherkassy,
            R.id.id_down_item_ukr,
            R.id.id_down_item_world
    })
    public void onClick(View view){

        if (MainActivity.isOnline()){
        switch (view.getId()){
            case R.id.id_down_item_smila :
                progressBarSmila.setVisibility(View.VISIBLE);
                setBackground(view);
                setRegion("smila");
                newsPresenter.loadNewsByRegion(getRegion(), "");
                break;
            case R.id.id_down_item_cherkassy :
                progressBarCherkassy.setVisibility(View.VISIBLE);
                setBackground(view);
                setRegion("cherkassy");
                newsPresenter.loadNewsByRegion(getRegion(), "");
                break;
            case R.id.id_down_item_ukr :
                progressBarUkraine.setVisibility(View.VISIBLE);
                setBackground(view);
                setRegion("ukraine");
                newsPresenter.loadNewsByRegion(getRegion(), "");
                break;
            case R.id.id_down_item_world :
                progressBarWorld.setVisibility(View.VISIBLE);
                setBackground(view);
                setRegion("world");
                newsPresenter.loadNewsByRegion(getRegion(), "");
                break;
        }}else {
            Snackbar.make(progressBar, "Інтернет відсутній", Snackbar.LENGTH_SHORT).show();
        }
    }

    private void setBackground(View view) {
        smilaDownItem.setBackgroundColor(Color.TRANSPARENT);
        cherkassyDownItem.setBackgroundColor(Color.TRANSPARENT);
        ukrDownItem.setBackgroundColor(Color.TRANSPARENT);
        worldDownItem.setBackgroundColor(Color.TRANSPARENT);
        view.setBackgroundColor(ContextCompat.getColor(this, R.color.textBackgroundButtonNews));
    }

    @NonNull
    @Override
    public NewsPresenter createPresenter() {
        return new NewsPresenterImpl(getApplicationContext());
    }

    public void refresh(ArrayList<News> newses) {
        if (getFragmentCommunicator() != null) {
            getFragmentCommunicator().updateRecycler(newses);
        }
    }

    @Override
    public void showNews(List<News> list) {
        progressBarSmila.setVisibility(View.INVISIBLE);
        progressBarCherkassy.setVisibility(View.INVISIBLE);
        progressBarUkraine.setVisibility(View.INVISIBLE);
        progressBarWorld.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.GONE);
        newList.clear();
        newList.addAll(list);
        fragmentNavigator.replaceFragment(NewsFragment.newInstance(newList, region), false);
    }

    @Override
    public void updateAllNews(ArrayList<News> newses) {
        progressBar.setVisibility(View.GONE);
        refresh(newses);
    }

    @Override
    public void showSelectedNews(Description description, View view) {
        fragmentNavigator.addFragment(NewsDescription.newInstance(description.getDescription(), view), true);
    }

    public NewsPresenter getNewsPresenter() {
        return newsPresenter;
    }

    public FragmentCommunicator getFragmentCommunicator() {
        return fragmentCommunicator;
    }

    public void setFragmentCommunicator(FragmentCommunicator fragmentCommunicator) {
        this.fragmentCommunicator = fragmentCommunicator;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
