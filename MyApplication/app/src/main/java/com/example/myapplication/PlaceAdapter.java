package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private final List<PlaceItem> items;

    // Defensive copy: prevents external modification
    public PlaceAdapter(List<PlaceItem> items) {
        this.items = new ArrayList<>(items);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_horizontal_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvPlaceName;
        private final TextView tvLocation;
        private final TextView tvRating;
        private final ImageView ivPlaceImage;
        private final ImageView ivFavorite;

        ViewHolder(View itemView) {
            super(itemView);
            tvPlaceName = itemView.findViewById(R.id.tvPlaceName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvRating = itemView.findViewById(R.id.tvRating);
            ivPlaceImage = itemView.findViewById(R.id.ivPlaceImage);
            ivFavorite = itemView.findViewById(R.id.ivFavorite);
        }

        void bind(PlaceItem item) {
            tvPlaceName.setText(item.getName());
            tvLocation.setText(item.getLocation());
            tvRating.setText(String.format("%.1f", item.getRating())); // e.g., "4.8" instead of "4.8000002"
            ivPlaceImage.setImageResource(item.getImageRes());

            // Optional: handle favorite click (example)
            ivFavorite.setOnClickListener(v -> {
                // TODO: Implement favorite toggle logic
                // e.g., update item.isFavorite(), notifyItemChanged(), etc.
            });
        }
    }
}