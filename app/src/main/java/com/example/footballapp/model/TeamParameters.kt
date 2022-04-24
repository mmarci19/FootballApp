package com.example.footballapp.model

import com.google.gson.annotations.SerializedName

data class TeamParameters (

    @SerializedName("season") var season: String? = null,
    @SerializedName("league") var league: String? = null
)