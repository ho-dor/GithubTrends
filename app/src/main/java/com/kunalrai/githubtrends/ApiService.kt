package com.kunalrai.githubtrends

import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://github-trending-api.now.sh"

val moshi: Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("repositories")
    fun getRepos(): Call<List<Repo>>
}

object Api {
    val RETROFIT_SERVICE : ApiService by lazy { retrofit.create(ApiService::class.java) }
}