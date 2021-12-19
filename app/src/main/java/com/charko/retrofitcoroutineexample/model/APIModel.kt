package com.charko.retrofitcoroutineexample.model

data class APIModel(
    val total_count: Int? = null,
    val incomplete_results: Boolean? = null,
    val items: List<UserInfo>? = null
)

