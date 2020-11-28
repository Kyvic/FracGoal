package com.mmu.fracgoal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VideoAdapterClass extends RecyclerView.Adapter<VideoAdapterClass.MyViewHolder> {
    Context context;
    ArrayList<Videos> list;

    public VideoAdapterClass(Context c, ArrayList<Videos> list){
        this.context = c;
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videolist_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.videoName.setText(list.get(position).getVideoName());
        //holder.videoUri.setText(list.get(position).getVideoUri());
        holder.videoPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, VideoViewer.class);
                intent.putExtra("videoUri", list.get(position).getVideoUri());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView videoName, videoUri;
        Button videoPlay;

        public MyViewHolder(View itemView){
            super(itemView);
            videoName = itemView.findViewById(R.id.videoName_text);
           videoUri = itemView.findViewById(R.id.videoUri_text);
           videoPlay = itemView.findViewById(R.id.videoPlay);

        }


    }
}

