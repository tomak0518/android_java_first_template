// CarouselAdapter.java
package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {

    private List<Place> places;

    public CarouselAdapter(List<Place> places) {
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carousel_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Place place = places.get(position);
        holder.textPlaceName.setText(place.getName());
        holder.imagePlace.setImageResource(place.getImageResId());

        // If using Glide for network images:
        // Glide.with(holder.itemView.getContext()).load(place.getImageUrl()).into(holder.imagePlace);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textPlaceName;
        ImageView imagePlace;

        ViewHolder(View itemView) {
            super(itemView);
            textPlaceName = itemView.findViewById(R.id.textPlaceName);
            imagePlace = itemView.findViewById(R.id.imagePlace);
        }
    }
}