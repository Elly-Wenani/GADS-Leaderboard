package com.example.gads.Fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads.Adapter.LearningLeaderAdapter;
import com.example.gads.LeaderBoardActivity;
import com.example.gads.Models.LearnerModel;
import com.example.gads.R;
import com.example.gads.Services.LeanerService;
import com.example.gads.Services.ServiceBuilder;
import com.example.gads.ui.main.PageViewModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LearningLeadersFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    RecyclerView mRecyclerView;

    //    private ArrayList<List<LearnerModel>> leaner;
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

//        leaner = new ArrayList<>();
//        leaner.add(new LearnerModel("Elly Wenani",
//                154, "Kenya", "Not Available"));

        mRecyclerView = leanerView.findViewById(R.id.rv_leaner);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // specifying an adapter
//        mLearningLeaderAdapter = new LearningLeaderAdapter(getContext(), leaner);
//        mRecyclerView.setAdapter(mLearningLeaderAdapter);

        /**
         * Fetch content using provided url
         */
        LeanerService leanerService = ServiceBuilder.builderService(LeanerService.class);
        Call<List<LearnerModel>> leanerRequest = leanerService.getLeaner();

        leanerRequest.enqueue(new Callback<List<LearnerModel>>() {
            @Override
            public void onResponse(Call<List<LearnerModel>> call, Response<List<LearnerModel>> response) {

                if (!response.isSuccessful()) {

                    Snackbar.make(requireView(), "Failed to load data", Snackbar.LENGTH_LONG).show();
                } else {
                    mLearningLeaderAdapter = new LearningLeaderAdapter(getContext(), response.body());
                    mRecyclerView.setAdapter(mLearningLeaderAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<LearnerModel>> call, Throwable t) {
                Snackbar.make(getView(), "Connection not available", Snackbar.LENGTH_LONG).show();
            }
        });

        return leanerView;
    }
}