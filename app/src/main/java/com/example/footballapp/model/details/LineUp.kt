package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName

data class LineUp (

    @SerializedName("formation"   ) var formation   : String?   = null,
    @SerializedName("played"  ) var played  : Int?  = 0
       )
