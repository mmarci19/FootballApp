package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName

data class Failed (
    @SerializedName("home" ) var streak : Int? = 0

)