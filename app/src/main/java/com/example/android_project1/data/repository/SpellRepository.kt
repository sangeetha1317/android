package com.example.android_project1.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.android_project1.data.model.SpellModel
import com.example.android_project1.service.ApiService
import retrofit2.Retrofit

class SpellRepository : ISpellRepository {
    override suspend fun getSpell(retrofit: Retrofit) : SpellModel {
        val spellService = retrofit.create(ApiService::class.java)
        val spellsResponse = spellService.getSpells()
        if (spellsResponse.isSuccessful){
            return spellsResponse.body() ?: throw Exception("Response body is null")
        } else {
            throw Exception("${spellsResponse.code()}")
        }
        }
    }


interface ISpellRepository{
    suspend fun getSpell(retrofit: Retrofit) : SpellModel
}