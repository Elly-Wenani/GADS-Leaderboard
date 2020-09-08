package com.example.gads.Services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IqService {

    @GET("api/skilliq")
    Call<String> getLeanerIq();
}
