package com.marand.database.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.marand.database.Table

@Entity(tableName = "post_table", primaryKeys = ["post_id"])
data class PostTable(
    @ColumnInfo(name = "post_id")
    val id: Int,
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "body")
    val body: String,
) : Table
