package com.example.trekkin.ui.community.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trekkin.R;

public class ProgrammingAdapterGroups extends RecyclerView.Adapter<ProgrammingAdapterGroups.ProgrammingViewHolderGroups> {
    private String[] data;
    public ProgrammingAdapterGroups(String[] data){
        this.data = data;
    }
    @NonNull
    @Override
    public ProgrammingViewHolderGroups onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout_groups, parent, false);
        return new ProgrammingViewHolderGroups(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolderGroups holder, int position) {
        String title = data[position];
        holder.textView.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingViewHolderGroups extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public ProgrammingViewHolderGroups(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profile_icon_groups);
            textView = itemView.findViewById(R.id.person_name_groups);
        }
    }
}
