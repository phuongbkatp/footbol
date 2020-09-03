package com.appnet.android.football.fbvn.service;


import com.appnet.android.football.fbvn.data.DetailNewsDataAuto;
import com.appnet.android.football.fbvn.data.NewsDataAuto;
import com.appnet.android.football.fbvn.data.NewsData;
import com.appnet.android.football.fbvn.data.UserIpData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestfulApiFootballAuto {

    @GET("news")
    Call<NewsDataAuto> loadNews(@Query("app") String team,
                                      @Query("category") String category,
                                      @Query("lang") String language);

    @GET("news/detail")
    Call<DetailNewsDataAuto> loadNewsDetail(@Query("url") String url);
    @GET("geoip/me/")
    Call<UserIpData> loadUserIp(@Header("Cache-Control") String cacheControl);
    @GET("match/video")
    Call<DetailNewsDataAuto> loadMatchVideo(@Query("home") String home, @Query("away") String away);

}
