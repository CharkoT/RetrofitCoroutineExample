package com.charko.retrofitcoroutineexample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charko.retrofitcoroutineexample.model.UserInfo
import com.charko.retrofitcoroutineexample.retrofit.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private var _users = MutableLiveData<List<UserInfo>>()
    val users: LiveData<List<UserInfo>> = _users
    var searchText = MutableLiveData<String>()

    fun requestUsers(query: String = "charko") {
        if (query.isNotEmpty()) {

            viewModelScope.launch(Dispatchers.IO) {
                try {
                    Retrofit().requestUsers(query).items?.let {
                        _users.postValue(it)
                    }
                } catch (e: Exception) {
                    Log.e(">>>>", "${e.localizedMessage}")
                }
            }
        }

//            Retrofit().requestUsers(query).enqueue(object : Callback<APIModel> {
//                override fun onResponse(call: Call<APIModel>, response: Response<APIModel>) {
//                    Log.e(">>>>>>>", "onRespose!!!!!!!!!!!!!!")
//                    response.body()?.items?.let {
//                        _users.postValue(it)
//                    }
//                }
//
//                override fun onFailure(call: Call<APIModel>, t: Throwable) {
//                    Log.e(">>>>>>>", "onFailure ${t.localizedMessage}")
//                }
//
//            })
    }

    fun onClickSearch() {
        requestUsers(searchText.value ?: "")
    }
}