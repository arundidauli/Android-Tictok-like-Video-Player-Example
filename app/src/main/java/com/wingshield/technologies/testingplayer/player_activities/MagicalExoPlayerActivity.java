package com.wingshield.technologies.testingplayer.player_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.view.Surface;

import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.steinwurf.mediaplayer.VideoDecoder;
import com.wingshield.technologies.testingplayer.MainActivity;
import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.UserClips;
import com.wingshield.technologies.testingplayer.UserViewAdapter;
import com.wingshield.technologies.testingplayer.adapter.MagicalExoPlayerAdapter;
import com.wingshield.technologies.testingplayer.adapter.MxPlayerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MagicalExoPlayerActivity extends AppCompatActivity {
    private static String TAG = MagicalExoPlayerActivity.class.getSimpleName();
    private List<UserClips> userClipsList;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magical_exo_player);
        context=MagicalExoPlayerActivity.this;
        userClipsList=new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.rv_video_view);
        setRecyclerView(recyclerView);
    }
    private void setRecyclerView(RecyclerView recyclerView) {
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        MagicalExoPlayerAdapter interestAdapter = new MagicalExoPlayerAdapter(context, userClipsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(interestAdapter);

    }

}