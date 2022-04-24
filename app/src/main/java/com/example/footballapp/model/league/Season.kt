package com.example.footballapp.model.league

import com.google.gson.annotations.SerializedName


data class Season (

    @SerializedName("year"     ) var year     : Int?      = null,
    @SerializedName("start"    ) var start    : String?   = null,
    @SerializedName("end"      ) var end      : String?   = null,
    @SerializedName("current"  ) var current  : Boolean?  = null,
    @SerializedName("coverage" ) var coverage : Coverage? = Coverage()

)