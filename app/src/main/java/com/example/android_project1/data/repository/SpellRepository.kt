package com.example.android_project1.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.android_project1.data.model.SpellModel
import com.example.android_project1.service.ApiService
import retrofit2.Retrofit

class SpellRepository : ISpellRepository {
    override suspend fun getSpell(retrofit: Retrofit, spellLiveData: MutableLiveData<SpellModel>) {
        val spellService = retrofit.create(ApiService::class.java)
        val spells = spellService.getSpells()
        spellLiveData.value = spells.body()
    }

}

interface ISpellRepository{
    suspend fun getSpell(retrofit: Retrofit, spellLiveData: MutableLiveData<SpellModel>)
}