package com.wingshield.technologies.testingplayer.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.UserClips;
import com.wingshield.technologies.testingplayer.VideoCache;

import java.util.List;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;


public class SimpleExoPlayerAdapter extends RecyclerView.Adapter<SimpleExoPlayerAdapter.MyViewHolder> {
    private static String TAG = SimpleExoPlayerAdapter.class.getSimpleName();
    private Context context;
    private List<UserClips> userClipsList;
    public SimpleExoPlayerAdapter(Context context, List<UserClips> userClipsList) {
        this.context = context;
        this.userClipsList = userClipsList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_exo_item_row_video, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(context, new DefaultTrackSelector(new DefaultBandwidthMeter.Builder(context).build()));

        String uri = "http://ia800208.us.archive.org/4/items/Popeye_forPresident/Popeye_forPresident_512kb.mp4";
        DataSource.Factory dataSourceFactory = new CacheDataSourceFactory(VideoCache.getInstance(context), new DefaultDataSourceFactory(context, Util.getUserAgent(context, "applicationName")));
        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(uri));
        player.prepare(videoSource);
        holder.simpleExoPlayer.setPlayer(player);
        player.setPlayWhenReady(true);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private SimpleExoPlayerView simpleExoPlayer;

        MyViewHolder(View view) {
            super(view);

            simpleExoPlayer = view.findViewById(R.id.player_view);



        }
    }


}
