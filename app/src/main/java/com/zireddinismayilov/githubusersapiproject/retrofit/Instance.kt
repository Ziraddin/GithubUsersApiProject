package com.zireddinismayilov.githubusersapiproject.retrofit

import com.zireddinismayilov.githubusersapiproject.globals.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Instance {
    val instance: IApi =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(IApi::class.java)
}