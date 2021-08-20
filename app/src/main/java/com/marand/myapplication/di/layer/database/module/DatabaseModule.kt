package com.marand.myapplication.di.layer.database.module

import android.content.Context
import com.marand.database.AppDatabase
import com.marand.database.Database
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [PreferencesModule::class])
class DatabaseModule {

    @Module
    companion object {

        @Singleton
        @Provides
        @JvmStatic
        fun provideDatabase(context: Context): AppDatabase {
            return Database(context).database
        }
    }
}
