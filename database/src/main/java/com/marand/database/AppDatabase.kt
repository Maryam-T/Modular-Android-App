package com.marand.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marand.database.post.PostDao
import com.marand.database.post.PostTable

@Database(
    version = BuildConfig.DATABASE_VERSION,
    entities = [PostTable::class],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
}