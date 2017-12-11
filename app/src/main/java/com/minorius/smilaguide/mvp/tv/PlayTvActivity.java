package com.minorius.smilaguide.mvp.tv;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

import com.minorius.smilaguide.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by minorius on 05.09.2017.
 */

public class PlayTvActivity extends AppCompatActivity {

    @BindView(R.id.id_video_view) VideoView videoView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_show_video);
        ButterKnife.bind(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        String url = getIntent().getExtras().getString("url");

        videoView.setVideoPath(url);
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();
        videoView.start();
    }
}
