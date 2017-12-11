package com.minorius.smilaguide.mvp.buy.vendor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.minorius.smilaguide.R;
import com.minorius.smilaguide.mvp.buy.vendor.fragment.BuyActivityViewPager;
import com.minorius.smilaguide.mvp.buy.visitor.BuyActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by minorius on 28.09.2017.
 */

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.sign_in_button) SignInButton signInButton;
    @BindView(R.id.id_progress_bar_login) ProgressBar progressBar;

    private FirebaseAuth mAuth;
    public GoogleApiClient mGoogleApiClient;

    private static final int RC_SIGN_IN = 2;

    private FirebaseAuth.AuthStateListener mAuthListeneer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_buy);
        ButterKnife.bind(this);


        mAuthListeneer = firebaseAuth -> {
            if (firebaseAuth.getCurrentUser() != null){
                //startActivity(new Intent(this, CreateOfferActivity.class));

                startActivity(new Intent(this, BuyActivityViewPager.class));
            }
        };

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, connectionResult -> {
                    progressBar.setVisibility(View.GONE);
                    Snackbar.make(signInButton, "Щось пішло не так: "+connectionResult, Snackbar.LENGTH_SHORT).show();
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        mAuth = FirebaseAuth.getInstance();
    }

    @OnClick(R.id.sign_in_button)
    public void onClick(){
        progressBar.setVisibility(View.VISIBLE);
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                progressBar.setVisibility(View.GONE);
                Snackbar.make(signInButton, "Помилка авторизації", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential);
    }

    @Override
    protected void onStart() {
        mAuth.addAuthStateListener(mAuthListeneer);
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, BuyActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        super.onBackPressed();
    }
}
