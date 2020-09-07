package com.example.gads.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gads.Models.IqScoreModel;
import com.example.gads.Models.LearnerModel;
import com.example.gads.R;

import java.util.List;

public class IqLeaderAdapter extends RecyclerView.Adapter<IqLeaderAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<IqScoreModel> mIqScoreModels;

    public IqLeaderAdapter(Context context, List<IqScoreModel> iqScoreModels){
        this.mLayoutInflater = LayoutInflater.from(context);
        mIqScoreModels = iqScoreModels;
    }

    @NonNull
    @Override
    public IqLeaderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.iq_row, parent, false);
        return new IqLeaderAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IqLeaderAdapter.ViewHolder holder, int position) {

        String learnerNameIq = mIqScoreModels.get(position).getLeanerNameIq();
        String learnerIqScore = Integer.toString(mIqScoreModels.get(position).getLearnerIqScore()) + " skill IQ Score, ";
        String learnerCountryIq = mIqScoreModels.get(position).getLeanerCountryIq();

        holder.learnerNameIq.setText(learnerNameIq);
        holder.learnerIqScore.setText(learnerIqScore);
        holder.learnerCountryIq.setText(learnerCountryIq);
    }

    @Override
    public int getItemCount() {
        return mIqScoreModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView learnerNameIq, learnerIqScore, learnerCountryIq;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            learnerNameIq = itemView.findViewById(R.id.tvLeanerNameIq);
            learnerIqScore = itemView.findViewById(R.id.tvSkillIq);
            learnerCountryIq = itemView.findViewById(R.id.tvCountryIq);
        }
    }
}
