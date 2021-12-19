package com.charko.retrofitcoroutineexample.retrofit

import com.charko.retrofitcoroutineexample.model.APIModel
import com.charko.retrofitcoroutineexample.model.UserInfo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor


class Retrofit {
    var githubService: GithubService

    init {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val retrofit =  Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        githubService = retrofit.create(GithubService::class.java)

    }

    fun requestUsers(query: String): Call<APIModel> = githubService.searchUsers(query)
}