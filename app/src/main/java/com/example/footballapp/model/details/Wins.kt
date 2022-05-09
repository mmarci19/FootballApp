package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName


data class Wins (

    @SerializedName("home"  ) var home  : Int? = null,
    @SerializedName("away"  ) var away  : Int? = null,
    @SerializedName("total" ) var total : Int? = null

)