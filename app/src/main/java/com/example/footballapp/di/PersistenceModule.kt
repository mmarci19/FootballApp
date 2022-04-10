package com.example.footballapp.di

import android.app.Application
import androidx.room.Room
import com.example.footballapp.R
import com.example.footballapp.persistence.AppDatabase
import com.example.footballapp.persistence.AppDatabase2
import com.example.footballapp.persistence.LeagueDao
import com.example.footballapp.persistence.TeamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase {
        return Room
            .databaseBuilder(
                application,
                AppDatabase::class.java,
                application.getString(R.string.database)
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideAppDatabase2(application: Application): AppDatabase2{
        return Room
            .databaseBuilder(
                application,
                AppDatabase2::class.java,
                application.getString(R.string.database2)
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTeamDao(appDatabase: AppDatabase): TeamDao {
        return appDatabase.teamDao()
    }

    @Provides
    @Singleton
    fun provideLeagueDao(appDatabase: AppDatabase2): LeagueDao {
        return appDatabase.leagueDao()
    }

}