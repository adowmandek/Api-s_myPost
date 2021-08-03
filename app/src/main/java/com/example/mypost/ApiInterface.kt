package com.example.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiInterface {
    @GET("posts")
    fun getPosts():Call<List<post>>

    @GET("post/{postId}")
    fun getPostById(@Path("id")postId:Int):Call<post>

    @GET("post/Comment")
    fun getPostByComment():Call<List<post>>

}