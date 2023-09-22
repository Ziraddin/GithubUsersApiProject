package com.zireddinismayilov.githubusersapiproject.retrofit

import com.zireddinismayilov.githubusersapiproject.data.RepositoryDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApi {
    @GET("repositories")
    fun getRepos(
        @Query("q") date: String,
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("page") pageCount: Int
    ): Call<RepositoryDTO?>?
}