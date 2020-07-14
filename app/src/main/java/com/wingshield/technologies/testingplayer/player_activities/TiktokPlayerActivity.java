package com.wingshield.technologies.testingplayer.player_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.allattentionhere.autoplayvideos.AAH_CustomRecyclerView;
import com.wingshield.technologies.testingplayer.MainActivity;
import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.adapter.MyVideosAdapter;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;

import static com.wingshield.technologies.testingplayer.utils.Utils.UserClipsList;

public class TiktokPlayerActivity extends AppCompatActivity {
    private static String TAG = TiktokPlayerActivity.class.getSimpleName();
    AAH_CustomRecyclerView recyclerView;
    private ProgressBar progressBar;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiktok_player);
        context=TiktokPlayerActivity.this;
        recyclerView=findViewById(R.id.rv_home);
        setAutoVideoRecycler_View();


    }

    void setAutoVideoRecycler_View() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        SlideInRightAnimationAdapter alphaInAnimationAdapter = new SlideInRightAnimationAdapter(new MyVideosAdapter(UserClipsList(), context));
        alphaInAnimationAdapter.setDuration(1000);
        alphaInAnimationAdapter.setInterpolator(new AccelerateDecelerateInterpolator());
        alphaInAnimationAdapter.setFirstOnly(false);
        recyclerView.setActivity(this);
        recyclerView.setPlayOnlyFirstVideo(false); // false by default
        recyclerView.setCheckForMp4(true); //true by default
        recyclerView.setDownloadPath(String.format("%s/MyVideo", Environment.getExternalStorageDirectory()));
        // (Environment.getExternalStorageDirectory() + "/Video") by default
        recyclerView.setDownloadVideos(false); // false by default
        recyclerView.setVisiblePercent(50); // percentage of View that needs to be visible to start playing
        recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaInAnimationAdapter));
        recyclerView.smoothScrollBy(0, 1);
        recyclerView.smoothScrollBy(0, -1);
    }

}