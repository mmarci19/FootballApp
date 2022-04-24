package com.example.footballapp.model

import com.google.gson.annotations.SerializedName

data class Coverage (

    @SerializedName("fixtures"    ) var fixtures    : Fixtures? = Fixtures(),
    @SerializedName("standings"   ) var standings   : Boolean?  = null,
    @SerializedName("players"     ) var players     : Boolean?  = null,
    @SerializedName("top_scorers" ) var topScorers  : Boolean?  = null,
    @SerializedName("top_assists" ) var topAssists  : Boolean?  = null,
    @SerializedName("top_cards"   ) var topCards    : Boolean?  = null,
    @SerializedName("injuries"    ) var injuries    : Boolean?  = null,
    @SerializedName("predictions" ) var predictions : Boolean?  = null,
    @SerializedName("odds"        ) var odds        : Boolean?  = null

)