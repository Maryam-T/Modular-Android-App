package com.marand.data.post.model

import com.marand.data.DataModel

data class PostDataModel (
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
) : DataModel