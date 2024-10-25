package com.example.android_project1.ui.characters

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project1.R
import com.example.android_project1.data.model.BookModel
import com.example.android_project1.data.model.CharacterModel
import com.example.android_project1.data.repository.BookRepository
import com.example.android_project1.data.repository.CharacterRepository
import com.example.android_project1.databinding.ActivityBooksBinding
import com.example.android_project1.databinding.ActivityCharacterBinding
import com.example.android_project1.network.RetrofitProvider
import com.example.android_project1.ui.books.BookViewModel
import com.example.android_project1.ui.books.adapter.BookAdapter
import com.example.android_project1.ui.characters.adapter.CharacterAdapter

class CharacterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCharacterBinding
    private lateinit var adapter: CharacterAdapter
    private val characterModel = CharacterModel()
    private lateinit var viewModel: CharacterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        adapter = CharacterAdapter(characterModel)
        binding.rv4.adapter = adapter
        binding.rv4.layoutManager = LinearLayoutManager(this)

        binding.toolbar.setTitle("Characters")

        val repository = CharacterRepository()
        viewModel.getCharacters(RetrofitProvider().retrofit, repository)

        viewModel.characterLiveData.observe(this) { characterData ->
            adapter.updateCharacters(characterData)
        }
    }

}