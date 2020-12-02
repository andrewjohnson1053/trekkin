package com.example.trekkin.ui.community;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.trekkin.R;
import com.google.android.material.tabs.TabLayout;

public class CommunityFragment extends Fragment {

    private CommunityViewModel communityViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        communityViewModel =
                new ViewModelProvider(this).get(CommunityViewModel.class);
        View root = inflater.inflate(R.layout.fragment_community, container, false);
        SectionsPagerAdapter communitySectionAdapter = new SectionsPagerAdapter(getContext(), getChildFragmentManager());
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.community_viewpager);
        viewPager.setAdapter(communitySectionAdapter);
        TabLayout tab_community = (TabLayout) root.findViewById(R.id.tab_community);
        //tab_community.setupWithViewPager(viewPager);


        tab_community.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_community));
        return root;
    }

}