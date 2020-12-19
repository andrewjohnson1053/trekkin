package com.example.trekkin.ui.explore.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trekkin.R;
import com.example.trekkin.ui.explore.LocationCard;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class ImageAdapter extends FirebaseRecyclerAdapter<LocationCard, ImageAdapter.ImageViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ImageAdapter(@NonNull FirebaseRecyclerOptions<LocationCard> options, Context context) {
        super(options);
        mContext = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ImageViewHolder holder, int position, @NonNull LocationCard card) {
        holder.textViewName.setText(card.getLocationName());
        Picasso.with(mContext)
                .load(card.getDisplayImageUrl())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .into(holder.imageView);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout_location_swatch, parent, false);
        return new ImageViewHolder(view);
    }

    private Context mContext;

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.location_swatch_location_name);
            imageView = itemView.findViewById(R.id.location_swatch_display_picture);
        }
    }
}
