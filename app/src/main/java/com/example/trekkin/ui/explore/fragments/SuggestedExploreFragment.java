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
import com.example.trekkin.ui.explore.LocationCard;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class SuggestedExploreFragment extends Fragment implements ProgrammingAdapterSuggested.OnExploreSuggestedItemClickListener {

    private SuggestedExploreViewModel mViewModel;
    private ImageAdapter imageAdapter;

    public static SuggestedExploreFragment newInstance() {
        return new SuggestedExploreFragment();
    }

    @Override
    public void onStart() {
        super.onStart();
        imageAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        imageAdapter.stopListening();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_suggested_explore, container, false);
        RecyclerView friendList = root.findViewById(R.id.suggested_recycler_view);
        friendList.setLayoutManager(new LinearLayoutManager(getContext()));
        friendList.setHasFixedSize(true);
//        String[] friends = {"person1", "person2", "person3", "person4", "person5", "person6", "person7", "person8", "person9", "person10", "person11", "person12", "person13", "person14", "person15", "person16", "person17", "person18", "person19", "person20"};
//        friendList.setAdapter(new ProgrammingAdapterSuggested(friends,this));
        Query query = FirebaseDatabase.getInstance().getReference().child("Locations");
        FirebaseRecyclerOptions<LocationCard> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<LocationCard>().setQuery(query, LocationCard.class).build();
        imageAdapter = new ImageAdapter(firebaseRecyclerOptions, getContext());
        friendList.setAdapter(imageAdapter);
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