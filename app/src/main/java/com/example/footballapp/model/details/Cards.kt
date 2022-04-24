package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName


data class Cards (

    @SerializedName("yellow" ) var yellow : Yellow? = Yellow()

)