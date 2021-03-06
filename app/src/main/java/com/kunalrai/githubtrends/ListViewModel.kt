package com.kunalrai.githubtrends

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {
    var repoList: MutableLiveData<List<Repo>> = MutableLiveData(listOf())

    fun getRepos(): MutableLiveData<List<Repo>>{

            repoList = MutableLiveData()
            loadRepos()

        return repoList
    }

    private fun loadRepos() {

        Api.RETROFIT_SERVICE.getRepos().enqueue( object: Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {
                if(response.body() != null){
                    repoList.value = response.body()

                }

            }
        })
    }

}
