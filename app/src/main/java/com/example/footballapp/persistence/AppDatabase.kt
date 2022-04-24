package com.example.footballapp.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.footballapp.model.League
import com.example.footballapp.model.Team

@Database(entities = [Team::class, League::class], version = 4, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun teamDao(): TeamDao

    abstract fun leagueDao(): LeagueDao


}