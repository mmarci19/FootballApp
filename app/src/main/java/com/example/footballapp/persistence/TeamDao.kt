package com.example.footballapp.persistence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapp.model.Team

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamList(teams: List<Team>)

    @Query("SELECT * FROM Team WHERE id = :id_")
    suspend fun getTeam(id_: String): Team?

    @Query("SELECT * FROM Team")
    suspend fun getTeamList(): List<Team>
}