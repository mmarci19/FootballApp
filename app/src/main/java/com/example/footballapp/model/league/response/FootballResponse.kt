package com.example.footballapp.model.league.response

import com.example.footballapp.model.league.Country
import com.example.footballapp.model.league.League
import com.example.footballapp.model.league.Season
import com.google.gson.annotations.SerializedName

data class FootballResponse (

    @SerializedName("league"  ) var league  : League?            = League(),
    @SerializedName("country" ) var country : Country?           = Country(),
    @SerializedName("seasons" ) var seasons : ArrayList<Season> = arrayListOf()

)