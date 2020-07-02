package com.wingshield.technologies.testingplayer.player_activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.res.Resources;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.adapter.VideoPlayerRecyclerView;
import com.wingshield.technologies.testingplayer.utils.MResources;
import com.wingshield.technologies.testingplayer.utils.MediaObject;
import com.wingshield.technologies.testingplayer.utils.VerticalSpacingItemDecorator;
import com.wingshield.technologies.testingplayer.utils.VideoPlayerRecyclerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class Exo2Activity extends AppCompatActivity {
    private static final String TAG = "Exo2Activity";

    private VideoPlayerRecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo2);
        initRecyclerView();
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        VerticalSpacingItemDecorator itemDecorator = new VerticalSpacingItemDecorator(10);
        mRecyclerView.addItemDecoration(itemDecorator);

        ArrayList<MediaObject> mediaObjects = new ArrayList<MediaObject>(Arrays.asList(MResources.MEDIA_OBJECTS));
        mRecyclerView.setMediaObjects(mediaObjects);
        VideoPlayerRecyclerAdapter adapter = new VideoPlayerRecyclerAdapter(mediaObjects, initGlide());
        mRecyclerView.setAdapter(adapter);
    }

    private RequestManager initGlide(){
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.ic_add_box)
                .error(R.drawable.ic_add_box);

        return Glide.with(this)
                .setDefaultRequestOptions(options);
    }


    @Override
    protected void onDestroy() {
        if(mRecyclerView!=null)
            mRecyclerView.releasePlayer();
        super.onDestroy();
    }
}