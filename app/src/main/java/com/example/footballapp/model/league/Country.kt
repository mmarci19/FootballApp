package com.example.footballapp.model.league

import com.google.gson.annotations.SerializedName


data class Country (

    @SerializedName("name" ) var name : String? = null,
    @SerializedName("code" ) var code : String? = null,
    @SerializedName("flag" ) var flag : String? = null

)