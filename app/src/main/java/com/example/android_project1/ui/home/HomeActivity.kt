package com.example.android_project1.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_project1.R
import com.example.android_project1.databinding.ActivityAboutBinding
import com.example.android_project1.databinding.ActivityHomeBinding
import com.example.android_project1.ui.books.BooksActivity
import com.example.android_project1.ui.spell.SpellActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.spellsId.setOnClickListener {
            val intent = Intent(this, SpellActivity::class.java)
            startActivity(intent)
        }

        binding.booksId.setOnClickListener {
            val intent = Intent(this, BooksActivity::class.java)
            startActivity(intent)
        }

        binding.charId.setOnClickListener {

        }
    }
}