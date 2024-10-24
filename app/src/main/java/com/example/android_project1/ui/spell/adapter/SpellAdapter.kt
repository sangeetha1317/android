package com.example.android_project1.ui.spell.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_project1.data.model.SpellModel
import com.example.android_project1.databinding.ItemSpellViewBinding

class SpellAdapter(var spellModel: SpellModel) : RecyclerView.Adapter<SpellViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        val binding = ItemSpellViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SpellViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return spellModel.size
    }

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        holder.binding.spellName.text = spellModel[position].spell
        holder.binding.spellDesc.text = spellModel[position].use
    }

    fun updateSpellsList(spells: SpellModel?) {
        val previousSpells = spellModel
        spellModel = spells?:previousSpells
        notifyDataSetChanged()
    }
}

class SpellViewHolder(val binding: ItemSpellViewBinding) : RecyclerView.ViewHolder(binding.root)