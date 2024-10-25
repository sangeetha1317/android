package com.example.android_project1.ui.characters

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.android_project1.data.model.CharacterModel
import com.example.android_project1.data.repository.CharacterRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class CharacterViewModel: ViewModel() {
    val characterLiveData = MutableLiveData<CharacterModel>()

    fun getCharacters(retrofit: Retrofit, repository: CharacterRepository) {
        viewModelScope.launch {
         repository.fetchCharacters(retrofit,characterLiveData)
        }
    }
}

