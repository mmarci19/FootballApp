package com.example.footballapp.model

import com.google.gson.annotations.SerializedName

data class FootballResponse (

    @SerializedName("league"  ) var league  : League?            = League(),
    @SerializedName("country" ) var country : Country?           = Country(),
    @SerializedName("seasons" ) var seasons : ArrayList<Seasons> = arrayListOf()

)