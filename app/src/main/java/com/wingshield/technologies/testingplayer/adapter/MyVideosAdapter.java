package com.wingshield.technologies.testingplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.allattentionhere.autoplayvideos.AAH_CustomViewHolder;
import com.allattentionhere.autoplayvideos.AAH_VideosAdapter;
import com.bumptech.glide.Glide;
import com.wingshield.technologies.testingplayer.AppController;
import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.UserClips;
import com.wingshield.technologies.testingplayer.utils.UserClip;

import java.util.List;


public class MyVideosAdapter extends AAH_VideosAdapter {

    private List<UserClip> list;
    private Context context;

    public MyVideosAdapter(List<UserClip> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public AAH_CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tourist_spot_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AAH_CustomViewHolder holder, int position) {
       // holder.setImageUrl(list.get(position).getThumb_url());
       // holder.setVideoUrl(String.valueOf(list.get(position).getVideo_url()));
        Glide.with(context).load(holder.getImageUrl())
                .placeholder(R.color.colorPrimary)
                .into(holder.getAAH_ImageView());
        if (list.get(position).getVideo_url()!=null){
            holder.setVideoUrl(AppController.getProxy(context).getProxyUrl(list.get(position).getVideo_url()+""));
        }

        ((MyViewHolder) holder).relative_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.isPlaying()) {
                    holder.pauseVideo();
                    holder.setPaused(true);
                    ((MyViewHolder) holder).img_play_pause.setVisibility(View.VISIBLE);

                } else {
                    holder.playVideo();
                    holder.setPaused(false);
                    ((MyViewHolder) holder).img_play_pause.setVisibility(View.GONE);

                }
            }
        });
        //to mute/un-mute video (optional)

        if (list.size() == 0) {
            ((MyViewHolder) holder).img_play_pause.setVisibility(View.GONE);
        } else {
            ((MyViewHolder) holder).img_play_pause.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //override this method to get callback when video starts to play

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    public class MyViewHolder extends AAH_CustomViewHolder {
        final ImageView img_play_pause;
        final RelativeLayout relative_id;
        boolean isMuted;

        public MyViewHolder(View x) {
            super(x);
            relative_id = x.findViewById(R.id.relative_id);
            img_play_pause = x.findViewById(R.id.img_play);
        }

        @Override
        public void videoStarted() {
            super.videoStarted();
            img_play_pause.setImageResource(R.mipmap.play_button);
            img_play_pause.setVisibility(View.GONE);
            if (isMuted) {
                muteVideo();
                // img_vol.setImageResource(R.drawable.ic_mute);
            } else {
                unmuteVideo();
                // img_vol.setImageResource(R.drawable.ic_unmute);
            }
        }

        @Override
        public void pauseVideo() {
            super.pauseVideo();
            img_play_pause.setImageResource(R.mipmap.play_button);
        }
    }

}