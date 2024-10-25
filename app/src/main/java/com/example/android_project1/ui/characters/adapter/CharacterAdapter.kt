package com.example.android_project1.ui.characters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_project1.R

import com.example.android_project1.data.model.CharacterModel
import com.example.android_project1.databinding.CharacterCellItemBinding

class CharacterAdapter (var characters: CharacterModel) : RecyclerView.Adapter<CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = CharacterCellItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return characters.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val imageUrl = characters[position].image
        holder.binding.name.text = characters[position].fullName
     holder.binding.actor.text = characters[position]. nickname
  holder.binding.textView8.text = characters[position].hogwartsHouse
        holder.binding.textView4.text = characters[position].birthdate
        holder.binding.textView5.text = characters[position].interpretedBy

        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.harry_image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.binding.imageView2)
    }

    fun updateCharacters(characterData: CharacterModel?) {
        characters = characterData?: CharacterModel()
        notifyDataSetChanged()
    }
}

class CharacterViewHolder(val binding: CharacterCellItemBinding) : RecyclerView.ViewHolder(binding.root)