package com.example.trekkin.ui.community.fragments;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trekkin.R;

public class ProgrammingAdapterFriends extends RecyclerView.Adapter<ProgrammingAdapterFriends.ProgramminViewHolderFriends>{

    private String[] data;
    private OnCommunityFriendItemClickListener mOnCommunityFriendItemClickListener;
    public ProgrammingAdapterFriends(String[] data, OnCommunityFriendItemClickListener onCommunityFriendItemClickListener){
        this.data = data;
        this.mOnCommunityFriendItemClickListener = onCommunityFriendItemClickListener;
    }

    @NonNull
    @Override
    public ProgramminViewHolderFriends onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout_friends, parent, false);
        return new ProgramminViewHolderFriends(view, mOnCommunityFriendItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramminViewHolderFriends holder, int position) {
        String title = data[position];
        holder.mPersonName.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class ProgramminViewHolderFriends extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView mProfileIcon;
        TextView mPersonName;
        OnCommunityFriendItemClickListener onCommunityFriendItemClickListener;
        public ProgramminViewHolderFriends(@NonNull View itemView,
                                           OnCommunityFriendItemClickListener onCommunityFriendItemClickListener) {
            super(itemView);
            mProfileIcon = itemView.findViewById(R.id.profile_icon);
            mPersonName = itemView.findViewById(R.id.person_name);
            this.onCommunityFriendItemClickListener = onCommunityFriendItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCommunityFriendItemClickListener.OnItemClicked(getAdapterPosition());
        }
    }

    public interface OnCommunityFriendItemClickListener {
        void OnItemClicked(int position);
    }
}
