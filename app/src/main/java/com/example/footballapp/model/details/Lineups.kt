package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName

data class Lineups (
    @SerializedName("streak" ) var lineups : ArrayList<LineUp> = arrayListOf()


        )
