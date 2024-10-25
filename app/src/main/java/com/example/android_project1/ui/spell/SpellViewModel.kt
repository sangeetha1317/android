package com.example.android_project1.ui.spell

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project1.data.model.SpellModel
import com.example.android_project1.data.repository.SpellRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit

sealed class SpellState {
    object Loading : SpellState()
    data class Success(val spells: SpellModel) : SpellState()
    data class Error(val message: String) : SpellState()
}

class SpellViewModel : ViewModel() {
    val spellLiveData = MutableLiveData<SpellState>()

    fun addSpells(retrofit: Retrofit, repository: SpellRepository) {
        viewModelScope.launch {
            try {
                val result = repository.getSpell(retrofit)
                spellLiveData.value = SpellState.Success(result)
            } catch (e: Exception) {
                spellLiveData.value = SpellState.Error("Sorry! Please try again later!!")
            }
        }
    }

}