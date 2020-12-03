package com.example.trekkin.ui.community.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trekkin.R;

public class FriendsCommunityFragment extends Fragment {

    private FriendsCommunityViewModel mViewModel;

    public static FriendsCommunityFragment newInstance() {
        return new FriendsCommunityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_friends_community, container, false);
        RecyclerView friendList = root.findViewById(R.id.friends_recycler_view);
        friendList.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] friends= {"person1", "person2", "person3", "person4", "person5", "person6", "person7", "person8", "person9", "person10"};
        friendList.setAdapter(new ProgrammingAdapterFriends(friends));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FriendsCommunityViewModel.class);
        // TODO: Use the ViewModel
    }


}