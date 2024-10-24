package com.example.android_project1.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitProvider {
    val baseUrl = " https://potterapi-fedeperin.vercel.app/"

    val retrofit by lazy { getRetrofitProvider() }

    private fun getRetrofitProvider() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}