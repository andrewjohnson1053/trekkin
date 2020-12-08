package com.example.trekkin.ui.community.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trekkin.R;

public class FriendsCommunityFragment extends Fragment implements ProgrammingAdapterFriends.OnCommunityFriendItemClickListener {

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
        String[] friends= {"person1", "person2", "person3", "person4", "person5", "person6", "person7", "person8", "person9", "person10", "person11", "person12", "person13", "person14", "person15", "person16", "person17", "person18", "person19", "person20"};
        friendList.setAdapter(new ProgrammingAdapterFriends(friends,this));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FriendsCommunityViewModel.class);
        // TODO: Use the ViewModel
    }


    @Override
    public void OnItemClicked(int position) {
        Log.d("COMM_FRNDS", "OnItemClicked: clicked " + position);

        
    }
}