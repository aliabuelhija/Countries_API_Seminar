package com.example.country;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServer {
    @GET("/calingcode/{country}")
     Call<JsonObject> findCalingCode(@Path("country") String country) ;
    @GET("/country/calingcode/{calingcode}")
    public Call<JsonObject> findNameByCalingCode(@Path("calingcode") String country) ;
    @GET("/capital/{country}")
    public Call<JsonObject> findCapitalByName(@Path("country") String country) ;
    @GET("/region/{country}")
    public Call<JsonObject> findRegionByName(@Path("country") String country) ;
    @GET("/flag/{country}")
    public Call<JsonObject> findFlagByName(@Path("country") String country) ;

}
