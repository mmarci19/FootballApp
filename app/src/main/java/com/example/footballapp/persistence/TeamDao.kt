package com.example.footballapp.persistence
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footballapp.model.team.Team


@Dao
interface TeamDao {

    @Query("SELECT * FROM Team WHERE id = :id__")
    fun getById(id__: Long) : Team

    @Query("SELECT * FROM Team WHERE league_id = :l_id")
    fun getAllTeams(l_id: String): List<Team>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeamList(teams: List<Team>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeam(team: Team)



}