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
    private OnCommunityGroupItemClickListener mOnCommunityGroupItemClickListener;
    public ProgrammingAdapterGroups(String[] data, OnCommunityGroupItemClickListener onCommunityGroupItemClickListener){
        this.data = data;
        this.mOnCommunityGroupItemClickListener = onCommunityGroupItemClickListener;
    }
    @NonNull
    @Override
    public ProgrammingViewHolderGroups onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout_groups, parent, false);
        return new ProgrammingViewHolderGroups(view, mOnCommunityGroupItemClickListener);
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

    public static class ProgrammingViewHolderGroups extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView textView;
        OnCommunityGroupItemClickListener onCommunityGroupItemClickListener;
        public ProgrammingViewHolderGroups(@NonNull View itemView, OnCommunityGroupItemClickListener onCommunityGroupItemClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profile_icon_groups);
            textView = itemView.findViewById(R.id.person_name_groups);
            this.onCommunityGroupItemClickListener = onCommunityGroupItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCommunityGroupItemClickListener.onItemClicked(getAdapterPosition());
        }
    }

    public interface OnCommunityGroupItemClickListener{
        void onItemClicked(int position);
    }
}
