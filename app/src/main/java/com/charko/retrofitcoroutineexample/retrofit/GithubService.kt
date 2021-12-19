package com.charko.retrofitcoroutineexample.retrofit

import com.charko.retrofitcoroutineexample.model.APIModel
import com.charko.retrofitcoroutineexample.model.UserInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {

    @GET("users/{user}repos")
    fun listRepos(@Path("user") user: String): Call<List<String>>

    @GET("search/users")
    fun searchUsers(@Query("q") query: String): Call<APIModel>
}