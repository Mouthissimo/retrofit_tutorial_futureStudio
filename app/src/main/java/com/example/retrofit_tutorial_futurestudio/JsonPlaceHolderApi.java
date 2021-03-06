package com.example.retrofit_tutorial_futurestudio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts")
    Call<List<Post>> getPostsQueryFromUserId(
            @Query("userId") Integer[] userIds,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    @GET("posts/1")
    Call<Post> getPostsFromUserId_1();

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    //Don't use
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostFormUrlEncoded(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );
}
