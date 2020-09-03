package com.appnet.android.football.fbvn.service;

import com.appnet.android.football.fbvn.data.AppConfigData;
import com.appnet.android.football.fbvn.data.CommentsData;
import com.appnet.android.football.fbvn.data.DefaultData;
import com.appnet.android.football.fbvn.data.DeviceTokenData;
import com.appnet.android.football.fbvn.data.LeagueData;
import com.appnet.android.football.fbvn.data.LeagueSeasonData;
import com.appnet.android.football.fbvn.data.ListNewsData;
import com.appnet.android.football.fbvn.data.ListNotificationConfigData;
import com.appnet.android.football.fbvn.data.NewsData;
import com.appnet.android.football.fbvn.data.NotificationConfigData;
import com.appnet.android.football.fbvn.data.OnOffAllNotificationData;
import com.appnet.android.football.fbvn.data.SignInAccountData;
import com.appnet.android.football.fbvn.data.UserProfileData;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestfulApiFootball {
    @GET("leagues/get/by")
    Call<LeagueData> loadLeaguesByTeam(@Query("team_id") int teamId, @Query("season_id") int seasonId);

    @GET("leagues/get/by")
    Call<LeagueData> loadLeaguesByTeam(@Header("Cache-Control") String cacheControl, @Query("team_id") int teamId, @Query("season_id") int seasonId);

    @GET("leagues/seasons/{season_id}/teams/{team_id}")
    Call<LeagueSeasonData> loadSeasonLeaguesByTeam(@Path("season_id") int seasonId, @Path("team_id") int teamId);

    @GET("leagues/seasons/{season_id}/teams/{team_id}")
    Call<LeagueSeasonData> loadSeasonLeaguesByTeam(@Header("Cache-Control") String cacheControl, @Path("season_id") int seasonId, @Path("team_id") int teamId);

    @GET("newses")
    Call<ListNewsData> loadNewsById(@Query("object_type") String objectType,
                                    @Query("object_id") int objectId,
                                    @Query("is_active") int active,
                                    @Query("language") String language,
                                    @Query("page") int page,
                                    @Query("per_page") int limit,
                                    @Query("order_by") String orderBy);

    @GET("newses")
    Call<ListNewsData> loadNewsById(@Header("Cache-Control") String cacheControl,
                                    @Query("object_type") String objectType,
                                    @Query("object_id") int objectId,
                                    @Query("is_active") int active,
                                    @Query("language") String language,
                                    @Query("page") int page,
                                    @Query("per_page") int limit,
                                    @Query("order_by") String orderBy);

    @GET("newses?refresh=true")
    Call<ListNewsData> refreshNewsById(@Query("object_type") String objectType,
                                       @Query("object_id") int objectId,
                                       @Query("is_active") int active,
                                       @Query("language") String language,
                                       @Query("page") int page,
                                       @Query("per_page") int limit,
                                       @Query("order_by") String orderBy);

    @GET("newses")
    Call<ListNewsData> loadNewsBySofa(@Query("object_type") String objectType,
                                      @Query("sofa_id") int sofaId,
                                      @Query("is_active") int active,
                                      @Query("language") String language,
                                      @Query("page") int page,
                                      @Query("per_page") int limit,
                                      @Query("order_by") String orderBy);

    @GET("newses")
    Call<ListNewsData> loadNewsBySofa(@Header("Cache-Control") String cacheControl,
                                      @Query("object_type") String objectType,
                                      @Query("sofa_id") int sofaId,
                                      @Query("is_active") int active,
                                      @Query("language") String language,
                                      @Query("page") int page,
                                      @Query("per_page") int limit,
                                      @Query("order_by") String orderBy);

    @GET("newses?refresh=true")
    Call<ListNewsData> refreshNewsBySofa(@Query("object_type") String objectType,
                                         @Query("sofa_id") int sofaId,
                                         @Query("is_active") int active,
                                         @Query("language") String language,
                                         @Query("page") int page,
                                         @Query("per_page") int limit,
                                         @Query("order_by") String orderBy);

    @GET("newses")
    Call<ListNewsData> loadNewsSofaByType(@Query("object_type") String objectType,
                                          @Query("sofa_id") int sofaId,
                                          @Query("is_active") int active,
                                          @Query("type") String type,
                                          @Query("page") int page,
                                          @Query("per_page") int limit,
                                          @Query("order_by") String orderBy);

    @GET("newses")
    Call<ListNewsData> loadNewsSofaByType(@Header("Cache-Control") String cacheControl,
                                          @Query("object_type") String objectType,
                                          @Query("sofa_id") int sofaId,
                                          @Query("is_active") int active,
                                          @Query("type") String type,
                                          @Query("page") int page,
                                          @Query("per_page") int limit,
                                          @Query("order_by") String orderBy);

    @GET("newses?refresh=true")
    Call<ListNewsData> refreshNewsSofaByType(@Query("object_type") String objectType,
                                             @Query("sofa_id") int sofaId,
                                             @Query("is_active") int active,
                                             @Query("type") String type,
                                             @Query("page") int page,
                                             @Query("per_page") int limit,
                                             @Query("order_by") String orderBy);

    @GET("newses")
    Call<ListNewsData> loadNewsByCategory(@Query("object_type") String objectType,
                                          @Query("object_id") int objectId,
                                          @Query("term_id") int categoryId,
                                          @Query("is_active") int active,
                                          @Query("language") String language,
                                          @Query("page") int page,
                                          @Query("per_page") int limit,
                                          @Query("order_by") String orderBy);

    @GET("newses")
    Call<ListNewsData> loadNewsByCategory(@Header("Cache-Control") String cacheControl,
                                          @Query("object_type") String objectType,
                                          @Query("object_id") int objectId,
                                          @Query("term_id") int categoryId,
                                          @Query("is_active") int active,
                                          @Query("language") String language,
                                          @Query("page") int page,
                                          @Query("per_page") int limit,
                                          @Query("order_by") String orderBy);

    @GET("newses?refresh=true")
    Call<ListNewsData> refreshNewsByCategory(@Query("object_type") String objectType,
                                             @Query("object_id") int objectId,
                                             @Query("term_id") int categoryId,
                                             @Query("is_active") int active,
                                             @Query("language") String language,
                                             @Query("page") int page,
                                             @Query("per_page") int limit,
                                             @Query("order_by") String orderBy);

    @GET("newses/get/{news_id}")
    Call<NewsData> loadNewsDetail(@Path("news_id") int newsId);

    @GET("newses/get/{news_id}")
    Call<NewsData> loadNewsDetail(@Header("Cache-Control") String cacheControl, @Path("news_id") int newsId);

    @GET("auth/login/social")
    Call<SignInAccountData> loginSocial(@Query("email") String email, @Query("social_id") String socialId,
                                        @Query("social_type") String socialType, @Query("full_name") String fullName,
                                        @Query("avatar") String avatar);

    @GET("auth/login")
    Call<SignInAccountData> login(@Query("email") String email, @Query("password") String password);

    @POST("auth/register")
    @FormUrlEncoded
    Call<SignInAccountData> register(@Field("email") String email, @Field("password") String password,
                                     @Field("password_confirmation") String confirmPassword, @Field("full_name") String fullName);

    @POST("register-device-token")
    @FormUrlEncoded
    Call<DeviceTokenData> registerDeviceToken(@Field("app_id") int appId, @Field("device_token_id") String deviceTokenId);

    @POST("register-device-token")
    @FormUrlEncoded
    Call<DeviceTokenData> registerDeviceToken(@Field("user_id") int userId, @Field("app_id") int appId, @Field("device_token_id") String deviceTokenId);

    @POST("device-follow-team")
    @FormUrlEncoded
    Call<DeviceTokenData> followTeam(@Field("app_id") int appId, @Field("team_id") int teamId, @Field("device_token_id") String deviceTokenId);


    @POST("device-follow-team")
    @FormUrlEncoded
    Call<DeviceTokenData> followTeam(@Field("user_id") int userId, @Field("app_id") int appId, @Field("team_id") int teamId, @Field("device_token_id") String deviceTokenId);


    @GET("comments")
    Call<CommentsData> loadComments(@Query("object_type") String objectType,
                                    @Query("object_id") int objectId,
                                    @Query("page") int page,
                                    @Query("per_page") int limit);
    @GET("comments")
    Call<CommentsData> loadComments(@Header("Cache-Control") String cacheControl,
                                    @Query("object_type") String objectType,
                                    @Query("object_id") int objectId,
                                    @Query("page") int page,
                                    @Query("per_page") int limit);

    @GET("comments?refresh=true")
    Call<CommentsData> refreshComments(@Query("object_type") String objectType,
                                       @Query("object_id") int objectId,
                                       @Query("page") int page,
                                       @Query("per_page") int limit);

    @GET("comments")
    Call<CommentsData> loadCommentsBySofa(@Query("object_type") String objectType,
                                          @Query("sofa_id") int sofaId,
                                          @Query("page") int page,
                                          @Query("per_page") int limit);

    @GET("comments")
    Call<CommentsData> loadCommentsBySofa(@Header("Cache-Control") String cacheControl,
                                          @Query("object_type") String objectType,
                                          @Query("sofa_id") int sofaId,
                                          @Query("page") int page,
                                          @Query("per_page") int limit);

    @GET("comments?refresh=true")
    Call<CommentsData> refreshCommentsBySofa(@Query("object_type") String objectType,
                                             @Query("sofa_id") int sofaId,
                                             @Query("page") int page,
                                             @Query("per_page") int limit);

    @POST("comments")
    @FormUrlEncoded
    Call<DefaultData> postComment(@Header("Authorization") String authorization,
                                  @Field("user_id") int userId,
                                  @Field("content") String content,
                                  @Field("object_type") String contentType,
                                  @Field("object_id") int objectId);


    @POST("comments/report")
    @FormUrlEncoded
    Call<DefaultData> reportComment(@Header("Authorization") String authorization,
                                    @Field("user_id") int userId,
                                    @Field("content") String content,
                                    @Field("comment_id") int contentId);

    @POST("comments")
    @FormUrlEncoded
    Call<DefaultData> postCommentBySofa(@Header("Authorization") String authorization,
                                        @Field("user_id") int userId,
                                        @Field("content") String content,
                                        @Field("object_type") String contentType,
                                        @Field("sofa_id") int objectId);

    @GET("appconfigs")
    Call<AppConfigData> loadAppConfigs(@Query("app_key") String appKey);

    @GET("appconfigs")
    Call<AppConfigData> loadAppConfigs(@Header("Cache-Control") String cacheControl, @Query("app_key") String appKey);

    @GET("appconfigs?refresh=true")
    Call<AppConfigData> refreshAppConfigs(@Query("app_key") String appKey);

    @GET("account/profile")
    Call<UserProfileData> loadUserProfile(@Header("Authorization") String authorization);

    @POST("account/profile")
    @FormUrlEncoded
    Call<UserProfileData> updateUserProfile(@Header("Authorization") String authorization,
                                            @Field("first_name") String firstName,
                                            @Field("last_name") String lastName,
                                            @Field("email") String email,
                                            @Field("gender") boolean male,
                                            @Field("address") String address);

    @POST("account/upload/avatar")
    @Multipart
    Call<UserProfileData> uploadAvatar(@Header("Authorization") String authorization, @Part MultipartBody.Part image);

    @GET("notification-configs")
    Call<ListNotificationConfigData> loadNotificationConfigs(@Query("app_id") int appId, @Query("device_token_id") String deviceToken);

    @POST("on-of-notification-config")
    @FormUrlEncoded
    Call<NotificationConfigData> setOnOffNotification(@Field("id") int id, @Field("is_enable") int value);

    @POST("on-of-notification")
    @FormUrlEncoded
    Call<OnOffAllNotificationData> setOnOffAllNotification(@Field("app_id") int appId, @Field("device_token_id") String deviceTokenId, @Field("is_enable") int value);

    class Factory {
        public static RestfulApiFootball create(String baseUrl) {
            OkHttpClient client = new OkHttpClient.Builder().build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(RestfulApiFootball.class);
        }
    }
}
