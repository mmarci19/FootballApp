package com.example.footballapp.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.footballapp.model.League
import com.example.footballapp.model.Team

@Database(entities = [Team::class, League::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDao

    abstract fun leagueDao(): LeagueDao

}