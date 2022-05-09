package com.example.footballapp.model.team.response

import com.example.footballapp.model.team.Team
import com.example.footballapp.model.team.Venue
import com.google.gson.annotations.SerializedName

data class TeamResponse (

    @SerializedName("team"  ) var team  : Team?            = Team(),
    @SerializedName("venue" ) var venue : Venue?           = Venue()

)