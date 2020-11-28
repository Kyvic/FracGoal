package com.mmu.fracgoal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    Context context;
    ArrayList<Materials> list;

    public AdapterClass(Context c, ArrayList<Materials> list){
        this.context = c;
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.materialName.setText(list.get(position).getMaterialName());
        holder.materialUri.setText(list.get(position).getMaterialUri());
        holder.viewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, PDFViewer.class);
                intent.putExtra("materialUri", list.get(position).getMaterialUri());
                context.startActivity(intent);
            }
        });


        holder.downloader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(list.get(position).getMaterialUri()));
                context.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView materialName, materialUri;
        Button viewer;
        Button downloader;
        public MyViewHolder(View itemView){
            super(itemView);
            materialName = itemView.findViewById(R.id.materialName_text);
            materialUri = itemView.findViewById(R.id.materialUri_text);
            viewer = itemView.findViewById(R.id.viewBtn);
            downloader = itemView.findViewById(R.id.downloadBtn);
        }



    }
}
