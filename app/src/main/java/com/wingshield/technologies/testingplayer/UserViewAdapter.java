package com.wingshield.technologies.testingplayer;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.VideoView;
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
import com.google.android.exoplayer2.upstream.cache.NoOpCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Util;
import com.wingshield.technologies.testingplayer.listnener.OnItemClickListener;

import java.io.File;
import java.util.List;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;
import hb.xvideoplayer.MxVideoPlayerWidget.Mode;

import static hb.xvideoplayer.MxVideoPlayerWidget.Mode.MODE_PLAYING_CLEAR;


public class UserViewAdapter extends RecyclerView.Adapter<UserViewAdapter.MyViewHolder> {
    private static String TAG = UserViewAdapter.class.getSimpleName();
    private Context context;
    private List<UserClips> userClipsList;
    private OnItemClickListener onItemClickListener;



    public UserViewAdapter(Context context, List<UserClips> userClipsList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.userClipsList = userClipsList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_video, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

      /*  holder.videoView.setOnPreparedListener((OnPreparedListener) context);
        holder.videoView.setVideoURI(Uri.parse("http://ia800208.us.archive.org/4/items/Popeye_forPresident/Popeye_forPresident_512kb.mp4"));
*/


      /*  holder.img_play.setVisibility(View.VISIBLE);
        holder.img_thumb.setVisibility(View.VISIBLE);*/
        //holder.videoPlayerWidget.startPlay("http://ia800208.us.archive.org/4/items/Popeye_forPresident/Popeye_forPresident_512kb.mp4", MxVideoPlayer.SCREEN_WINDOW_FULLSCREEN, "");
      //  holder.videoPlayerWidget.setAllControlsVisible(0,0,1,0,1,0);

        //videoPlayerWidget.startPlay("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4", MxVideoPlayer.SCREEN_LAYOUT_NORMAL, "");
       // holder.videoPlayerWidget.autoStartPlay("http://ia800208.us.archive.org/4/items/Popeye_forPresident/Popeye_forPresident_512kb.mp4", MxVideoPlayer.SCREEN_WINDOW_FULLSCREEN, "");



        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(context, new DefaultTrackSelector(new DefaultBandwidthMeter.Builder(context).build()));

        String uri = "http://ia800208.us.archive.org/4/items/Popeye_forPresident/Popeye_forPresident_512kb.mp4";
        DataSource.Factory dataSourceFactory = new CacheDataSourceFactory(VideoCache.getInstance(context), new DefaultDataSourceFactory(context, Util.getUserAgent(context, "applicationName")));
        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
                .createMediaSource(Uri.parse(uri));
        player.prepare(videoSource);
        holder.videoView.setPlayer(player);
        holder.img_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.img_play.setVisibility(View.GONE);
                holder.img_thumb.setVisibility(View.GONE);
                player.setPlayWhenReady(true);
            }
        });

        if (position!=RecyclerView.NO_POSITION){
            player.setPlayWhenReady(false);
            player.release();
        }








    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_thumb,img_play;
        private SimpleExoPlayerView videoView;
        private MxVideoPlayerWidget videoPlayerWidget;

        MyViewHolder(View view) {
            super(view);
            videoView = view.findViewById(R.id.player_view);
            videoPlayerWidget = view.findViewById(R.id.mpw_video_player);
            img_thumb = view.findViewById(R.id.img_thumb);
            img_play = view.findViewById(R.id.img_play);



        }
    }


}
