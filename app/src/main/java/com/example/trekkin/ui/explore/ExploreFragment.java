package com.example.trekkin.ui.explore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.trekkin.R;
import com.google.android.material.tabs.TabLayout;

public class ExploreFragment extends Fragment {

    private ExploreViewModel exploreViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        exploreViewModel =
                new ViewModelProvider(this).get(ExploreViewModel.class);
        View root = inflater.inflate(R.layout.fragment_explore, container, false);
        SectionsPagerAdapter explorePagerAdapter = new SectionsPagerAdapter(getContext(),getChildFragmentManager());
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.explore_viewpager);
        viewPager.setAdapter(explorePagerAdapter);
        TabLayout tab_explore = (TabLayout) root.findViewById(R.id.tab_explore);
        tab_explore.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return root;
    }
}