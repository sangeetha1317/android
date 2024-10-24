package com.example.android_project1.ui.about

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.android_project1.R
import com.example.android_project1.databinding.ActivityAboutBinding
import com.example.android_project1.ui.spell.SpellActivity

class AboutActivity : AppCompatActivity() {
    lateinit var binding : ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.nextBtn.setOnClickListener {
            val intent = Intent(this,SpellActivity::class.java)
            startActivity(intent)
        }

    }
}