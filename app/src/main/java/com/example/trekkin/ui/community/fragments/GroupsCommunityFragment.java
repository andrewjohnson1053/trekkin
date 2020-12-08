package com.example.trekkin.ui.community.fragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.trekkin.R;

public class GroupsCommunityFragment extends Fragment implements ProgrammingAdapterGroups.OnCommunityGroupItemClickListener {

    private GroupsCommunityViewModel mViewModel;

    public static GroupsCommunityFragment newInstance() {
        return new GroupsCommunityFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_groups_community, container, false);
        RecyclerView group_list = root.findViewById(R.id.groups_recycler_view);
        group_list.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] groups = {"Group1", "Group2", "Group3"};
        group_list.setAdapter(new ProgrammingAdapterGroups(groups,this));
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(GroupsCommunityViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onItemClicked(int position) {
        Log.d("COMM_GROUP", "onItemClicked: clicked " + position);
    }
}