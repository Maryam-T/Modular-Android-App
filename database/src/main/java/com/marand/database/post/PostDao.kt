package com.marand.database.post

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPostList(postTableList: List<PostTable>)

    @Query("select * from post_table where user_id = :userId")
    suspend fun queryUserPostList(userId: Int): List<PostTable>
}