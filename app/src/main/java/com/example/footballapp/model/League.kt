package com.example.footballapp.model

import androidx.compose.runtime.Immutable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
@Immutable
data class League (
    @PrimaryKey val id_: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "logo") val logo: String,
    @ColumnInfo(name = "type") val type: String
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