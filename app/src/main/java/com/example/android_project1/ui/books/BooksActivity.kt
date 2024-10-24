package com.example.android_project1.ui.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project1.data.model.BookModel

import com.example.android_project1.data.repository.BookRepository
import com.example.android_project1.databinding.ActivityBooksBinding
import com.example.android_project1.network.RetrofitProvider
import com.example.android_project1.ui.books.adapter.BookAdapter

class BooksActivity : AppCompatActivity() {
    lateinit var binding: ActivityBooksBinding
    lateinit var adapter: BookAdapter
    val bookModel = BookModel()
    lateinit var viewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(BookViewModel::class.java)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        adapter = BookAdapter(bookModel)
        binding.rvId.adapter = adapter
        binding.rvId.layoutManager = LinearLayoutManager(this)

        binding.toolbar.setTitle("Home")

        val repository = BookRepository()
        viewModel.getBooks(RetrofitProvider().retrofit, repository)

        viewModel.booksLiveData.observe(this) { bookData ->
            adapter.updateBooks(bookData)
        }

    }
}
