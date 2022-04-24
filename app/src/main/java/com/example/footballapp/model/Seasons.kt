package com.example.footballapp.model

import com.google.gson.annotations.SerializedName


data class Seasons (

    @SerializedName("year"     ) var year     : Int?      = null,
    @SerializedName("start"    ) var start    : String?   = null,
    @SerializedName("end"      ) var end      : String?   = null,
    @SerializedName("current"  ) var current  : Boolean?  = null,
    @SerializedName("coverage" ) var coverage : Coverage? = Coverage()

)