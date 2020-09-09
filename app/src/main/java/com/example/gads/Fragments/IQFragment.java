package com.example.gads.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads.Adapter.IqLeaderAdapter;
import com.example.gads.Adapter.LearningLeaderAdapter;
import com.example.gads.Models.IqScoreModel;
import com.example.gads.Models.LearnerModel;
import com.example.gads.R;
import com.example.gads.Services.IqService;
import com.example.gads.Services.LeanerService;
import com.example.gads.Services.ServiceBuilder;
import com.example.gads.ui.main.PageViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IQFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    RecyclerView mRecyclerView;

//    private ArrayList<IqScoreModel> score;
    IqLeaderAdapter mIqLeaderAdapter;

    public static IQFragment newInstance(int index) {
        IQFragment fragment = new IQFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View iqView = inflater.inflate(R.layout.skilliq_fragment, container, false);

//        score = new ArrayList<>();
//        score.add(new IqScoreModel("Elly Wenani", 286, "Kenya", "Not Available"));

        mRecyclerView = iqView.findViewById(R.id.rv_iq_score);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // specifying an adapter
        /**
         * Fetch content using provided url
         */
        IqService iqService = ServiceBuilder.builderService(IqService.class);
        Call<List<IqScoreModel>> iqRequest = iqService.getLeanerIq();

        iqRequest.enqueue(new Callback<List<IqScoreModel>>() {
            @Override
            public void onResponse(Call<List<IqScoreModel>> call, Response<List<IqScoreModel>> response) {

                mIqLeaderAdapter = new IqLeaderAdapter(getContext(), response.body());
                mRecyclerView.setAdapter(mIqLeaderAdapter);
            }

            @Override
            public void onFailure(Call<List<IqScoreModel>> call, Throwable t) {
                Snackbar.make(getView(), "Failed to load data", Snackbar.LENGTH_LONG).show();
            }
        });

        return iqView;
    }
}
