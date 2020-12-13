package com.example.trekkin.ui.explore.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trekkin.R;

public class ProgrammingAdapterFavourites extends RecyclerView.Adapter<ProgrammingAdapterFavourites.ProgrammingViewHolderFavourites> {
    private String[] data;
    private OnExploreFavouritesItemClickListener mOnExploreFavouritesItemClickListener;
    public ProgrammingAdapterFavourites(String[] data, OnExploreFavouritesItemClickListener onExploreFavouritesItemClickListener){
        this.data = data;
        mOnExploreFavouritesItemClickListener = onExploreFavouritesItemClickListener;
    }

    @NonNull
    @Override
    public ProgrammingAdapterFavourites.ProgrammingViewHolderFavourites onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_item_layout_location_swatch, parent, false);
        return new ProgrammingAdapterFavourites.ProgrammingViewHolderFavourites(view, mOnExploreFavouritesItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingAdapterFavourites.ProgrammingViewHolderFavourites holder, int position) {
        String title = data[position];
        holder.mLocationName.setText(title);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class ProgrammingViewHolderFavourites extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mLocationName;
        OnExploreFavouritesItemClickListener mOnExploreFavouritesItemClickListener;
        public ProgrammingViewHolderFavourites(@NonNull View itemView,
                                              OnExploreFavouritesItemClickListener onExploreFavouritesItemClickListener) {
            super(itemView);
            mLocationName = itemView.findViewById(R.id.location_swatch_location_name);
            this.mOnExploreFavouritesItemClickListener = onExploreFavouritesItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mOnExploreFavouritesItemClickListener.OnItemClicked(getAdapterPosition());
        }
    }

    public interface OnExploreFavouritesItemClickListener {
        void OnItemClicked(int position);
    }
}
