package com.example.android_project1.service

import com.example.android_project1.data.model.SpellModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("en/spells")
    suspend fun getSpells() : Response<SpellModel>
}