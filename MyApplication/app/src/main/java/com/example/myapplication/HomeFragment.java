// HomeFragment.java
package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
// HomeFragment.java
public class HomeFragment extends Fragment {

    private static final String ARG_SELECTED_TAB = "selected_tab";
    private static final String[] PAGE_TITLES = {"Most View", "Nearby", "Latest"};

    // Factory method to create HomeFragment with selected tab
    public static HomeFragment newInstance(int selectedTab) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SELECTED_TAB, selectedTab);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewPager2 viewPager = view.findViewById(R.id.viewPager);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);

        viewPager.setAdapter(new MyPagerAdapter(this));

        // Restore selected tab from arguments (e.g., after rotation)
        int selectedTab = 0;
        if (getArguments() != null) {
            selectedTab = getArguments().getInt(ARG_SELECTED_TAB, 0);
        }
        viewPager.setCurrentItem(selectedTab, false);

        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            tab.setText(PAGE_TITLES[position]);
        }).attach();

    }

    // Adapter (same as before)
    public static class MyPagerAdapter extends FragmentStateAdapter {
        public MyPagerAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position) {
                case 0: return new Tab1Fragment();
                case 1: return new Tab2Fragment();
                case 2: return new Tab3Fragment();
                default: return new Tab1Fragment();
            }
        }

        @Override
        public int getItemCount() {
            return PAGE_TITLES.length;
        }
    }
}