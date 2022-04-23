package com.example.footballapp.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity

@Entity
@Immutable
data class Team (
    val id_: String,
    val name: String,
    val league: String,
    val logo: String,
    val goalScored: String,
    val penalties: String,
    val yellowCards: String,
    val cleanSheets: String,
    val wins: String,
    val loses: String
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