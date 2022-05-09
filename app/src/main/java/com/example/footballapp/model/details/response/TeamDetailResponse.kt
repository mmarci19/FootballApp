package com.example.footballapp.model.details.response

import com.example.footballapp.model.details.*
import com.example.footballapp.model.league.Fixtures
import com.example.footballapp.model.league.League
import com.example.footballapp.model.team.Team
import com.google.gson.annotations.SerializedName

data class TeamDetailResponse (

    @SerializedName("league"        ) var league      : League = League(),
    @SerializedName("team"        ) var team      : Team = Team(),
    @SerializedName("form"        ) var form      : String? = null,
    //@SerializedName("fixtures"        ) var fixtures      : com.example.footballapp.model.details.Fixtures?          = com.example.footballapp.model.details.Fixtures(),
    //@SerializedName("goals"  ) var goals  : Goals? = Goals(),
    //@SerializedName("biggest"  ) var biggest  : Biggest? = Biggest(),
    @SerializedName("failed_to_score"  ) var failed : Failed? =  Failed(),
    @SerializedName("clean_sheet"  ) var cleanSheets : CleanSheets? =  CleanSheets(),
    @SerializedName("penalty" ) var penalty : Penalties? = Penalties(),
    @SerializedName("cards" ) var cards : Cards? = Cards(),


    )