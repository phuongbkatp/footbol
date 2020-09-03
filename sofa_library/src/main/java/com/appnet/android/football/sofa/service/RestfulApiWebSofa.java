package com.appnet.android.football.sofa.service;

import com.appnet.android.football.sofa.data.Game;
import com.appnet.android.football.sofa.data.WebApiDataResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestfulApiWebSofa {
    String BASE_URL =  "https://www.sofascore.com/";

    @GET("{sport}//{date}/json") //football//2019-07-27/json
    Call<WebApiDataResponse> loadSportSchedule(@Path("sport") String sport, @Path("date") String date);

    class Factory {
        public static RestfulApiWebSofa create() {
            return create(BASE_URL);
        }

        public static RestfulApiWebSofa create(String baseUrl) {
            OkHttpClient client = new OkHttpClient.Builder().build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            return retrofit.create(RestfulApiWebSofa.class);
        }
    }
}
