package com.example.trekkin.ui.explore.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trekkin.R;
import com.example.trekkin.ui.community.fragments.ProgrammingAdapterFriends;

public class ProgrammingAdapterSuggested extends RecyclerView.Adapter<ProgrammingAdapterSuggested.ProgrammingViewHolderSuggested> {
    private String[] data;
    private OnExploreSuggestedItemClickListener mOnExploreSuggestedItemClickListener;
    public ProgrammingAdapterSuggested(String[] data, OnExploreSuggestedItemClickListener onExploreSuggestedItemClickListener){
        this.data = data;
        mOnExploreSuggestedItemClickListener = onExploreSuggestedItemClickListener;
    }

    @NonNull
    @Override
    public ProgrammingAdapterSuggested.ProgrammingViewHolderSuggested onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout_location_swatch, parent, false);
        return new ProgrammingAdapterSuggested.ProgrammingViewHolderSuggested(view, mOnExploreSuggestedItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingAdapterSuggested.ProgrammingViewHolderSuggested holder, int position) {
        String title = data[position];
        holder.mLocationName.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class ProgrammingViewHolderSuggested extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mLocationName;
        OnExploreSuggestedItemClickListener mOnExploreSuggestedItemClickListener;
        public ProgrammingViewHolderSuggested(@NonNull View itemView,
                                           OnExploreSuggestedItemClickListener onExploreSuggestedItemClickListener) {
            super(itemView);
            mLocationName = itemView.findViewById(R.id.location_swatch_location_name);
            this.mOnExploreSuggestedItemClickListener = onExploreSuggestedItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnExploreSuggestedItemClickListener.OnItemClicked(getAdapterPosition());
        }
    }

    public interface OnExploreSuggestedItemClickListener {
        void OnItemClicked(int position);
    }
}
