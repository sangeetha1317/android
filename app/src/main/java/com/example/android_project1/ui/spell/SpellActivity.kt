package com.example.android_project1.ui.spell

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project1.data.model.SpellModel
import com.example.android_project1.data.repository.SpellRepository
import com.example.android_project1.databinding.ActivitySpellBinding
import com.example.android_project1.network.RetrofitProvider
import com.example.android_project1.ui.spell.adapter.SpellAdapter

class SpellActivity : AppCompatActivity() {
    lateinit var binding: ActivitySpellBinding
    lateinit var adapter: SpellAdapter
    val spellList = SpellModel()
    lateinit var viewModel: SpellViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpellBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        viewModel = ViewModelProvider(this).get(SpellViewModel::class.java)

        adapter = SpellAdapter(spellList)
        binding.spellRv.layoutManager = LinearLayoutManager(this)
        binding.spellRv.adapter = adapter

        binding.toolbar.setTitle("Spells")



        getSpells()
        getSpellsFromLiveData()
    }

    private fun getSpellsFromLiveData() {
        viewModel.spellLiveData.observe(this, Observer {
            when (it) {
                is SpellState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.errorText.visibility = View.GONE
                }
                is SpellState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorText.visibility = View.GONE
                    adapter.updateSpellsList(it.spells)

                }
                is SpellState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.errorText.visibility = View.VISIBLE
                    binding.errorText.text = it.message
                }
            }
        })
    }

    private fun getSpells() {
        val repository = SpellRepository()
        viewModel.addSpells(RetrofitProvider().retrofit,repository)
    }
}