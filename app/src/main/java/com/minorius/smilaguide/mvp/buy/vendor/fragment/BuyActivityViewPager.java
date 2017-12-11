package com.minorius.smilaguide.mvp.buy.vendor.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.mvp.buy.vendor.fragment.FragmentCreateBuy;
import com.minorius.smilaguide.mvp.buy.visitor.BuyActivity;
import com.minorius.smilaguide.mvp.buy.vendor.fragment.FragmentDeleteBuy;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by minorius on 01.10.2017.
 */

public class BuyActivityViewPager extends AppCompatActivity implements FragmentCreateBuy.FragmentCommunicatorBuy {

    @BindView(R.id.id_btn_log_out)          Button logOut;

    private FirebaseAuth                    firebaseAuth;
    private FirebaseAuth.AuthStateListener  authStateListener;
    private GoogleApiClient                 mGoogleApiClient;
    private TabAdapter                      tabAdapter;
    @Override
    protected void onStart() {
        firebaseAuth.addAuthStateListener(authStateListener);
        super.onStart();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_view_pager);

        ButterKnife.bind(this);

        firebaseAuth = FirebaseAuth.getInstance();

        ViewPager viewPager = (ViewPager) findViewById(R.id.id_view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.id_tabs);
        tabAdapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, connectionResult -> {
                    Snackbar.make(logOut, "Щось пішло не так: "+connectionResult, Snackbar.LENGTH_SHORT).show();
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        authStateListener = firebaseAuth -> {
            if (firebaseAuth.getCurrentUser() == null){
                startActivity(new Intent(this, BuyActivity.class));
            }
        };
    }

    @OnClick(R.id.id_btn_log_out)
    public void onClick() {
        firebaseAuth.signOut();
        Auth.GoogleSignInApi.signOut(mGoogleApiClient);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, BuyActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        super.onBackPressed();
    }

    @Override
    public void updateRecycler() {
        String tag = "android:switcher:" + R.id.id_view_pager + ":" + 1;
        FragmentDeleteBuy fragmentDeleteBuy = (FragmentDeleteBuy) getSupportFragmentManager().findFragmentByTag(tag);
        fragmentDeleteBuy.loadOffersList(tabAdapter);
    }

    public class TabAdapter extends FragmentPagerAdapter {

        private static final int TAB_COUNT = 2;

        public TabAdapter(FragmentManager fm) {
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
                    return FragmentCreateBuy.newInstance();
                case 1:
                    return FragmentDeleteBuy.newInstance();
            }

            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Створити";
                case 1:
                    return "Видалити";
            }
            return "Tab " + String.valueOf(position);
        }

    }
}
