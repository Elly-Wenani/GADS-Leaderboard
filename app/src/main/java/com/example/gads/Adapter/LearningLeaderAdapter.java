package com.example.gads.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads.Models.LearnerModel;
import com.example.gads.R;

import java.util.List;


public class LearningLeaderAdapter extends RecyclerView.Adapter<LearningLeaderAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<LearnerModel> mLearnerModels;

    public LearningLeaderAdapter(Context context, List<LearnerModel> learningLeadersModels){
        this.mLayoutInflater = LayoutInflater.from(context);
        mLearnerModels = learningLeadersModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.learner_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String learnerName = mLearnerModels.get(position).getLeanerName();
        String learnerHours = Integer.toString(mLearnerModels.get(position).getLearningHours()) + " learning hours, ";
        String learnerCountry = mLearnerModels.get(position).getLeanerCountry();

        holder.learnerName.setText(learnerName);
        holder.learnerHours.setText(learnerHours);
        holder.learnerCountry.setText(learnerCountry);
    }

    @Override
    public int getItemCount() {
        return mLearnerModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView learnerName, learnerHours, learnerCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            learnerName = itemView.findViewById(R.id.tvLeanerName);
            learnerHours = itemView.findViewById(R.id.tvLearningHours);
            learnerCountry = itemView.findViewById(R.id.tvLeanerCountry);
        }
    }
}
