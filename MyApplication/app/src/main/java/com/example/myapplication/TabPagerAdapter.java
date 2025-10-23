package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

// TabPagerAdapter.java
public class TabPagerAdapter extends FragmentStateAdapter {

    private final String[] tabTypes = {
            PlaceListFragment.TAB_MOST_VIEWED,
            PlaceListFragment.TAB_NEARBY,
            PlaceListFragment.TAB_LATEST
    };

    private final String[] tabTitles = {"Most Viewed", "Nearby", "Latest"};

    public TabPagerAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PlaceListFragment.newInstance(tabTypes[position]);
    }

    @Override
    public int getItemCount() {
        return tabTypes.length;
    }

    public String getTitle(int position) {
        return tabTitles[position];
    }
}