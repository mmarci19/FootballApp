package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName

data class Biggest (
    @SerializedName("streak" ) var streak : String? = null
)
