package com.example.footballapp.model

import com.google.gson.annotations.SerializedName

data class FootballResponseArray (

    var responseList: ArrayList<FootballResponse> = arrayListOf()

)