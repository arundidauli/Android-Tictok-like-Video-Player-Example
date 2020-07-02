package com.wingshield.technologies.testingplayer.player_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Context;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.UserClips;
import com.wingshield.technologies.testingplayer.adapter.MxPlayerAdapter;
import com.wingshield.technologies.testingplayer.adapter.RAnimationAdapter;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

public class RecyclerAnimationActivity extends AppCompatActivity {
    private static String TAG = RecyclerAnimationActivity.class.getSimpleName();
    private List<UserClips> userClipsList;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleranimation);
        context=RecyclerAnimationActivity.this;
        userClipsList=new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.rv_video_view);
        setRecyclerView(recyclerView);
    }
    private void setRecyclerView(RecyclerView recyclerView) {
      /*  SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);*/

        SlideInLeftAnimationAdapter alphaInAnimationAdapter = new SlideInLeftAnimationAdapter(new RAnimationAdapter());
        alphaInAnimationAdapter.setDuration(1000);
        alphaInAnimationAdapter.setInterpolator(new DecelerateInterpolator());
        alphaInAnimationAdapter.setFirstOnly(false);
        RAnimationAdapter interestAdapter = new RAnimationAdapter(context, userClipsList);
        //RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView.setLayoutManager(mLayoutManager);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(interestAdapter);
        recyclerView.setAdapter(new ScaleInAnimationAdapter(alphaInAnimationAdapter));
    }
}