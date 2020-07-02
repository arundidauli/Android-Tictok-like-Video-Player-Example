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
import com.wingshield.technologies.testingplayer.adapter.JcVideoPlayerAdapter;
import com.wingshield.technologies.testingplayer.adapter.MxPlayerAdapter;

import java.util.ArrayList;
import java.util.List;

public class JCVideoPlayerStandardActivity extends AppCompatActivity {
    private static String TAG = JCVideoPlayerStandardActivity.class.getSimpleName();
    private List<UserClips> userClipsList;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_c_video_player_standard);
        context=JCVideoPlayerStandardActivity.this;
        userClipsList=new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.rv_video_view);
        setRecyclerView(recyclerView);
    }
    private void setRecyclerView(RecyclerView recyclerView) {
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        JcVideoPlayerAdapter interestAdapter = new JcVideoPlayerAdapter(context, userClipsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        //GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(interestAdapter);

    }
}