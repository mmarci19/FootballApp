package com.example.footballapp.model.team

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
@Immutable
data class Team (

    @PrimaryKey @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("code" ) var code : String? = null,
    @SerializedName("logo" ) var logo : String? = null,
    @SerializedName("country") var country : String? = null,
    @SerializedName("national") var national : Boolean? = null,
    var league_id : String? = null

)
{

    companion object {

        fun mock() = Team(
            id = 0,
            name = "Ferencvarosi TC",
            code = "HU",
            logo = "https://google.com",
            country = "Hungary",
            national = false,
            league_id = "100"
        )
    }
}





