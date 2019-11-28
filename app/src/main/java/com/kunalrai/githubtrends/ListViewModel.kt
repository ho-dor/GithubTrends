package com.kunalrai.githubtrends

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var recyclerAdapter: RecyclerAdapter = RecyclerAdapter(context = null)

    init {
        getRepos()
    }


    private fun getRepos() {
        Api.RETROFIT_SERVICE.getRepos().enqueue( object: Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                Log.i("Failure: ", t.message)
            }

            override fun onResponse(call: Call<List<Repo>>, response: Response<List<Repo>>) {

                if(response.body() != null)
                    recyclerAdapter.setRepoListItems(response.body()!!)
            }
        })
    }
}
