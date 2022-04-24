package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName


data class Penalties (

    @SerializedName("scored" ) var scored : Scored? = Scored(),

)