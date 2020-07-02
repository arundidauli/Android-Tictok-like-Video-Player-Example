package com.wingshield.technologies.testingplayer.player_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;

import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.UserClips;
import com.wingshield.technologies.testingplayer.adapter.MxPlayerAdapter;
import com.wingshield.technologies.testingplayer.adapter.SimpleExoPlayerAdapter;

import java.util.ArrayList;
import java.util.List;

public class SimpleExoPlayerActivity extends AppCompatActivity {
    private static String TAG = SimpleExoPlayerActivity.class.getSimpleName();
    private List<UserClips> userClipsList;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_exo_player);
        context=SimpleExoPlayerActivity.this;
        userClipsList=new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.rv_video_view);
        setRecyclerView(recyclerView);
    }
    private void setRecyclerView(RecyclerView recyclerView) {
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        SimpleExoPlayerAdapter interestAdapter = new SimpleExoPlayerAdapter(context, userClipsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(interestAdapter);

    }
}