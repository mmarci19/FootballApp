package com.example.footballapp.model.team

import com.example.footballapp.model.league.Paging
import com.example.footballapp.model.team.response.TeamResponse
import com.google.gson.annotations.SerializedName

data class TeamModel (

    @SerializedName("get"  ) var get  : String?            = null,
    @SerializedName("parameters" ) var params : TeamParameters?           = TeamParameters(),
    @SerializedName("errors" ) var errors : ArrayList<String> = arrayListOf(),
    @SerializedName("paging"  ) var paging  : Paging?         = Paging(),
    @SerializedName("results") var results: Number? = null,
    @SerializedName("response" ) var responses : ArrayList<TeamResponse>           = arrayListOf()

)
{
    companion object {

        fun mock() = TeamModel(
            get = "league",
            params = TeamParameters(),
            errors = ArrayList<String>(),
            paging = Paging(),
            results = 5,
            responses = ArrayList<TeamResponse>(),
        )
    }

}
