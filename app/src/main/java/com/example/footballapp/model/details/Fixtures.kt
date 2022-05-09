package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName


data class Fixtures (
    @SerializedName("wins"   ) var wins   : Wins?   = Wins(),
    @SerializedName("loses"  ) var loses  : Loses?  = Loses()
)