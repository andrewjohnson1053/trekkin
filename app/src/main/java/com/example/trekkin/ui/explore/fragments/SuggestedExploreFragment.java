package com.example.trekkin.ui.explore.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trekkin.R;

public class SuggestedExploreFragment extends Fragment implements ProgrammingAdapterSuggested.OnExploreSuggestedItemClickListener {

    private SuggestedExploreViewModel mViewModel;

    public static SuggestedExploreFragment newInstance() {
        return new SuggestedExploreFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_suggested_explore, container, false);
        RecyclerView friendList = root.findViewById(R.id.suggested_recycler_view);
        friendList.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] friends= {"person1", "person2", "person3", "person4", "person5", "person6", "person7", "person8", "person9", "person10", "person11", "person12", "person13", "person14", "person15", "person16", "person17", "person18", "person19", "person20"};
        friendList.setAdapter(new ProgrammingAdapterSuggested(friends,this));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SuggestedExploreViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void OnItemClicked(int position) {

    }
}