package com.example.gads.Services;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LeanerService {
    @GET("api/hours")
    Call<String> getLeaner();
}
