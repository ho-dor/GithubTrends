package com.kunalrai.githubtrends

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private val _response = MutableLiveData<String>()

    // The external immutable LiveData for the response String
    val response: LiveData<String>
        get() = _response


    init {
        getRepos()
    }


    private fun getRepos() {
        Api.RETROFIT_SERVICE.getRepos().enqueue( object: Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                _response.value = "Success: ${response.body()?.size} repos fetched"
            }
        })
    }
}
