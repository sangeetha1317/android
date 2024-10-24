package com.example.android_project1.ui.books.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_project1.R
import com.example.android_project1.data.model.BookModel
import com.example.android_project1.data.model.SpellModel
import com.example.android_project1.databinding.BookCellViewBinding
import com.example.android_project1.databinding.ItemSpellViewBinding
import com.example.android_project1.ui.spell.adapter.SpellViewHolder

class BookAdapter(var books: BookModel) : RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = BookCellViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val imageUrl = books[position].cover
        holder.binding.bookTitle.text = books[position].title
        holder.binding.releaseId.text = books[position].releaseDate
        holder.binding.descId.text = books[position].description
        holder.binding.pagesId.text = books[position].pages.toString()
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .placeholder(R.drawable.harry_image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.binding.bookImg)
    }

    fun updateBooks(bookData: BookModel?) {
        books = bookData?:BookModel()
        notifyDataSetChanged()
    }
}

class BookViewHolder(val binding: BookCellViewBinding) : RecyclerView.ViewHolder(binding.root)