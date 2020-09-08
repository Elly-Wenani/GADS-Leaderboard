package com.example.gads.Services;

import com.example.gads.Models.LearnerModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeanerService {

    @GET("api/hours")
    Call<List<LearnerModel>> getLeaner();
}
