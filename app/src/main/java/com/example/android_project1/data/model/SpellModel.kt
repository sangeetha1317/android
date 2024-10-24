package com.example.android_project1.data.model

class SpellModel : ArrayList<SpellModelItem>()

data class SpellModelItem(
    val index: Int,
    val spell: String,
    val use: String
)