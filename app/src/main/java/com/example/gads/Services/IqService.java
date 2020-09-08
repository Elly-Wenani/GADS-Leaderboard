package com.example.gads.Services;

import com.example.gads.Models.IqScoreModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IqService {

    @GET("api/skilliq")
    Call<List<IqScoreModel>> getLeanerIq();
}
