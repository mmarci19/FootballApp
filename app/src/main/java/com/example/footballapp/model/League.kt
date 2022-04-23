package com.example.footballapp.model

import androidx.compose.runtime.Immutable
import androidx.room.Entity


@Entity
@Immutable
data class League (
    val id_: String,
    val name: String,
    val logo: String,
    val type: String
)
{

    companion object {

        fun mock() = League(
            id_ = "271",
            name = "NB I",
            type = "League",
            logo = "https://media.api-sports.io/football/leagues/271.png"

        )
    }
}