package com.example.footballapp.model

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
@Immutable
data class Team (
    @PrimaryKey val id_: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "league") val league: String,
    @ColumnInfo(name = "logo") val logo: String,
    @ColumnInfo(name = "goals") val goalScored: String,
    @ColumnInfo(name = "penalties") val penalties: String,
    @ColumnInfo(name = "yellowcards") val yellowCards: String,
    @ColumnInfo(name = "cleansheets") val cleanSheets: String,
    @ColumnInfo(name = "wins") val wins: String,
    @ColumnInfo(name = "loses") val loses: String
)
{

    companion object {

        fun mock() = Team(

            id_ = "651",
            name =  "Ferencvarosi TC",
            logo = "https://media.api-sports.io/football/teams/651.png",
            wins = "18",
            league = "271" ,
            loses = "5",
            goalScored = "49",
            cleanSheets = "13",
            penalties = "6",
            yellowCards = "6"
        )
    }

}