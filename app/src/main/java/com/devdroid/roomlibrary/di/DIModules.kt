package com.devdroid.roomlibrary.di

import android.app.Application
import androidx.room.Room
import com.devdroid.roomlibrary.model.database.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent :: class)
object DIModules  {




    @Singleton
    @Provides
    fun provideDatabase(context: Application): ContactDatabase {

        return Room.databaseBuilder(
            context.baseContext,
            ContactDatabase::class.java,
            "contact_database"
        ).build()



    }

}