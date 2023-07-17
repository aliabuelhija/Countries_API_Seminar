package com.example.country;

import android.util.Log;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryInfoService {
    private static final String TAG = CountryInfoService.class.getSimpleName();
    private static CountryInfoService countryInfoService = new CountryInfoService();
    private ApiServer apiServer = RetrofitService.getInstance().getRetrofit().create(ApiServer.class);

    public static CountryInfoService getInstance() {
        return countryInfoService;
    }

    public void findCalingCode(String country, CallBack_Country callback) {
        makeApiCall(apiServer.findCalingCode(country), "callingCode", callback);
    }

    public void findNameByCalingCode(String callingCode, CallBack_Country callback) {
        makeApiCall(apiServer.findNameByCalingCode(callingCode), "name", callback);
    }

    public void findFlagByName(String country, CallBack_Country callback) {
        makeApiCall(apiServer.findFlagByName(country), "smallFlag", callback);
    }

    public void findRegionByName(String country, CallBack_Country callback) {
        makeApiCall(apiServer.findRegionByName(country), "region", callback);
    }

    public void findCapitalByName(String country, CallBack_Country callback) {
        makeApiCall(apiServer.findCapitalByName(country), "capital", callback);
    }

    private void makeApiCall(Call<JsonObject> call, String resultKey, CallBack_Country callback) {
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject jsonObject = response.body();
                    if (jsonObject != null && jsonObject.has(resultKey)) {
                        String result = jsonObject.get(resultKey).getAsString();
                        callback.data(result);
                    } else {
                        onFailure(call, new Throwable("Failed to retrieve " + resultKey));
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e(TAG, "API call failed: ", t);
                callback.data(null);
            }
        });
    }

    public interface CallBack_Country {
        void data(String result);
    }
}
