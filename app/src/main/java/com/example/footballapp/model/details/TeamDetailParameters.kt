package com.example.footballapp.model.details

import com.google.gson.annotations.SerializedName

data class TeamDetailParameters (

    @SerializedName("league") var league: String? = null,
    @SerializedName("team") var team: String? = null,
    @SerializedName("season") var season: String? = null
    )