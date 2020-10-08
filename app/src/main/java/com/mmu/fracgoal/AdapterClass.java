package com.mmu.fracgoal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.materialName.setText(list.get(position).getMaterialName());
        holder.materialUri.setText(list.get(position).getMaterialUri());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView materialName, materialUri;
        public MyViewHolder(View itemView){
            super(itemView);
            materialName = itemView.findViewById(R.id.materialName_text);
            materialUri = itemView.findViewById(R.id.materialUri_text);
        }


    }
}
