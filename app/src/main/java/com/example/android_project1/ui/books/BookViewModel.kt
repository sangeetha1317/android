package com.example.android_project1.ui.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_project1.data.model.BookModel
import com.example.android_project1.data.repository.BookRepository
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class BookViewModel: ViewModel() {
    val booksLiveData = MutableLiveData<BookModel>()

    fun getBooks(retrofit: Retrofit, repository: BookRepository) {
        viewModelScope.launch {
            repository.fetchBooks(retrofit, booksLiveData)
        }
    }
}