package com.example.footballapp.model

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
@Immutable

data class League (

    @PrimaryKey @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("type" ) var type : String? = null,
    @SerializedName("logo" ) var logo : String? = null

)

{

    companion object {

        fun mock() = League(
            id = 271,
            name = "NB I",
            type = "League",
            logo = "https://media.api-sports.io/football/leagues/271.png"

        )
    }
}