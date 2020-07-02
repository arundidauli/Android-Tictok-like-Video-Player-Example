package com.wingshield.technologies.testingplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.exoplayer2.ui.PlayerView;
import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.UserClips;

import java.util.List;

import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;


public class ExoPlayerAdapter extends RecyclerView.Adapter<ExoPlayerAdapter.MyViewHolder> {
    private static String TAG = ExoPlayerAdapter.class.getSimpleName();
    private Context context;
    private List<UserClips> userClipsList;
    public ExoPlayerAdapter(Context context, List<UserClips> userClipsList) {
        this.context = context;
        this.userClipsList = userClipsList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exo_item_row_video, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private PlayerView videoPlayerWidget;

        MyViewHolder(View view) {
            super(view);

            videoPlayerWidget = view.findViewById(R.id.player_view);



        }
    }


}
