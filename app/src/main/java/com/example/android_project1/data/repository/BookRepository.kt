package com.example.android_project1.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.android_project1.data.model.BookModel
import com.example.android_project1.data.model.SpellModel
import com.example.android_project1.service.ApiService
import retrofit2.Retrofit

class BookRepository: RepositoryBooks {
    override suspend fun fetchBooks(retrofit: Retrofit, bookLiveData: MutableLiveData<BookModel>) {
        val bookService = retrofit.create(ApiService::class.java)
        val books = bookService.getBooks()
        bookLiveData.value = books.body()
    }
}

interface RepositoryBooks{
    suspend fun fetchBooks(retrofit: Retrofit, bookLiveData: MutableLiveData<BookModel>)
}
