package com.wingshield.technologies.testingplayer.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wingshield.technologies.testingplayer.R;
import com.wingshield.technologies.testingplayer.UserClips;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;
import hb.xvideoplayer.MxVideoPlayer;
import hb.xvideoplayer.MxVideoPlayerWidget;


public class JcVideoPlayerAdapter extends RecyclerView.Adapter<JcVideoPlayerAdapter.MyViewHolder> {
    private static String TAG = JcVideoPlayerAdapter.class.getSimpleName();
    private Context context;
    private List<UserClips> userClipsList;
    public JcVideoPlayerAdapter(Context context, List<UserClips> userClipsList) {
        this.context = context;
        this.userClipsList = userClipsList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.jc_item_row_video, parent, false);



        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

       //  holder.videoPlayerWidget.autoStartPlay("http://ia800208.us.archive.org/4/items/Popeye_forPresident/Popeye_forPresident_512kb.mp4", MxVideoPlayer.SCREEN_WINDOW_FULLSCREEN, "");
        holder.jcVideoPlayerStandard.setUp("http://ia800208.us.archive.org/4/items/Popeye_forPresident/Popeye_forPresident_512kb.mp4"
                , JCVideoPlayerStandard.SCREEN_WINDOW_FULLSCREEN, "");
        holder.jcVideoPlayerStandard.thumbImageView.setImageURI(Uri.parse("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640"));

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private JCVideoPlayerStandard jcVideoPlayerStandard;

        MyViewHolder(View view) {
            super(view);

            jcVideoPlayerStandard = view.findViewById(R.id.video_player);



        }
    }


}
