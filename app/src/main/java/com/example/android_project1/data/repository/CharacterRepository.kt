package com.example.android_project1.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.android_project1.data.model.CharacterModel
import com.example.android_project1.service.ApiService
import retrofit2.Retrofit

class CharacterRepository : CharacterInterface{
override suspend fun fetchCharacters(retrofit: Retrofit, characterLiveData: MutableLiveData<CharacterModel>) {
    val characterService = retrofit.create(ApiService::class.java)
    val characters = characterService.getCharacters()
    characterLiveData.value = characters.body()
}}

interface CharacterInterface {
    suspend fun fetchCharacters(retrofit: Retrofit, characterLiveData: MutableLiveData<CharacterModel>)

}