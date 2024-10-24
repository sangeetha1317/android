package com.example.android_project1.ui.spell

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project1.data.model.SpellModel
import com.example.android_project1.data.repository.SpellRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class SpellViewModel : ViewModel() {
    val spellLiveData = MutableLiveData<SpellModel>()

    fun addSpells(retrofit: Retrofit, repository: SpellRepository) {
        viewModelScope.launch {
            repository.getSpell(retrofit,spellLiveData)
        }
    }

}