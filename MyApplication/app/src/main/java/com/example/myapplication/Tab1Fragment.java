// Tab1Fragment.java
package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import java.util.List;

public class Tab1Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewCarousel);

        // Sample data
        List<Place> places = Arrays.asList(
                new Place("Mount Fuji", R.drawable.bg1),
                new Place("Kyoto Temple", R.drawable.bg2),
                new Place("Osaka Castle", R.drawable.bg1),
                new Place("Nara Park", R.drawable.bg2)
        );

        CarouselAdapter adapter = new CarouselAdapter(places);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        return view;
    }
}