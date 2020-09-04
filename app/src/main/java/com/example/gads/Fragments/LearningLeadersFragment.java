package com.example.gads.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads.Adapter.LearningLeaderAdapter;
import com.example.gads.Models.LearnerModel;
import com.example.gads.R;
import com.example.gads.ui.main.PageViewModel;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class LearningLeadersFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    RecyclerView mRecyclerView;

    private ArrayList<LearnerModel> leaner;
    LearningLeaderAdapter mLearningLeaderAdapter;


    public static LearningLeadersFragment newInstance(int index) {
        LearningLeadersFragment fragment = new LearningLeadersFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View leanerView = inflater.inflate(R.layout.learner_fragment, container, false);

        leaner = new ArrayList<>();
        leaner.add(new LearnerModel("Elly Wenani", 154, "Kenya", "Not Available"));

        mRecyclerView = leanerView.findViewById(R.id.rv_leaner);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // specifying an adapter
        mLearningLeaderAdapter = new LearningLeaderAdapter(getContext(), leaner);
        mRecyclerView.setAdapter(mLearningLeaderAdapter);

        return leanerView;
    }
}