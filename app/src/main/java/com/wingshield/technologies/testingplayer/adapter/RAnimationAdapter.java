package com.wingshield.technologies.testingplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.UserClips;

import java.util.List;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;


public class RAnimationAdapter extends RecyclerView.Adapter<RAnimationAdapter.MyViewHolder> {
    private static String TAG = RAnimationAdapter.class.getSimpleName();
    private Context context;
    private List<UserClips> userClipsList;
    public RAnimationAdapter(Context context, List<UserClips> userClipsList) {
        this.context = context;
        this.userClipsList = userClipsList;

    }

    public RAnimationAdapter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.r_an_item_row_video, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        // holder.videoPlayerWidget.autoStartPlay("http://ia800208.us.archive.org/4/items/Popeye_forPresident/Popeye_forPresident_512kb.mp4", MxVideoPlayer.SCREEN_WINDOW_FULLSCREEN, "");


    }

    @Override
    public int getItemCount() {
        return 22;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView videoPlayerWidget;

        MyViewHolder(View view) {
            super(view);

            //videoPlayerWidget = view.findViewById(R.id.mpw_video_player);



        }
    }


}
