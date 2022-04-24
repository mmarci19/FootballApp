package com.example.footballapp.model

import com.google.gson.annotations.SerializedName

data class TeamResponse (

    @SerializedName("team"  ) var team  : Team?            = Team(),
    @SerializedName("venue" ) var venue : Venue?           = Venue()

)