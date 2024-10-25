package com.example.android_project1.data.model

import android.provider.ContactsContract.CommonDataKinds.Nickname

class CharacterModel : ArrayList<CharacterItem>()

        data class CharacterItem(
            val fullName:String,
            val nickname: String,
            val hogwartsHouse:String,
            val interpretedBy:String,
            val image:String,
            val birthdate:String,
            val children: List<String>



)