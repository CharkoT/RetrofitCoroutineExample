package com.charko.retrofitcoroutineexample.model

data class UserInfo(
    var login: String? = null,
    var avatar_url: String? = null,
    var html_url: String? = null
)