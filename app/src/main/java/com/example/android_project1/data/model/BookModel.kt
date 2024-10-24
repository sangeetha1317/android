package com.example.android_project1.data.model

class BookModel : ArrayList<BookItem>()

data class BookItem(
    val number: Number,
    val title: String,
    val originalTitle: String,
    val releaseDate:String,
    val description: String,
    val pages: Number,
    val cover: String
)
