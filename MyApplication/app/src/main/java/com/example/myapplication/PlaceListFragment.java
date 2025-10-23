package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlaceListFragment extends Fragment {

    private static final String ARG_TAB_TYPE = "tab_type";
    public static final String TAB_MOST_VIEWED = "most_viewed";
    public static final String TAB_NEARBY = "nearby";
    public static final String TAB_LATEST = "latest";

    public static PlaceListFragment newInstance(String tabType) {
        PlaceListFragment fragment = new PlaceListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TAB_TYPE, tabType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState); // 👈 Good practice

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false));

        String tabType = "";
        if (getArguments() != null) {
            tabType = getArguments().getString(ARG_TAB_TYPE, "");
        }

        List<PlaceItem> items = getPlaceData(tabType);
        PlaceAdapter adapter = new PlaceAdapter(items);
        recyclerView.setAdapter(adapter);
    }

    private List<PlaceItem> getPlaceData(String tabType) {
        List<PlaceItem> list = new ArrayList<>();

        if (TAB_MOST_VIEWED.equals(tabType)) {
            list.add(new PlaceItem("Mount Fuji", "Tokyo, Japan", 4.8f, R.drawable.bg1));
            list.add(new PlaceItem("Eiffel Tower", "Paris, France", 4.7f, R.drawable.bg2));
        } else if (TAB_NEARBY.equals(tabType)) {
            list.add(new PlaceItem("Central Park", "New York, USA", 4.6f, R.drawable.bg1));
        } else if (TAB_LATEST.equals(tabType)) {
            list.add(new PlaceItem("Santorini", "Greece", 4.9f, R.drawable.bg2));
        }
        // Optional: else return empty list (already handled)

        return list;
    }
}