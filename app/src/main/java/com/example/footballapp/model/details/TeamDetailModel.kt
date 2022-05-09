package com.example.footballapp.model.details
import com.example.footballapp.model.details.response.TeamDetailResponse
import com.example.footballapp.model.league.Paging
import com.example.footballapp.model.league.Parameters
import com.google.gson.annotations.SerializedName


data class TeamDetailModel (
    @SerializedName("get"  ) var get  : String?            = null,
    @SerializedName("parameters" ) var params : TeamDetailParameters?           = TeamDetailParameters(),
    @SerializedName("paging"  ) var paging  : Paging?         = Paging(),
    @SerializedName("results") var results: Number? = null,
    @SerializedName("response" ) var responses : TeamDetailResponse    = TeamDetailResponse()

){
    companion object {

        fun mock() = TeamDetailModel(
            get = "team/statistics",
            params = TeamDetailParameters(),
            paging = Paging(),

            results = 5,
            responses = TeamDetailResponse(),
        )
    }

}