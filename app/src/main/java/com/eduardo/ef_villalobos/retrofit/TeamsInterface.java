package com.eduardo.ef_villalobos.retrofit;

import com.eduardo.ef_villalobos.retrofit.model.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface TeamsInterface {

    @GET("teams")
    Call<List<Teams>> getShowTeams();
}
