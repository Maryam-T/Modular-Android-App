package com.marand.remote.post.dto

import com.google.gson.annotations.SerializedName
import com.marand.remote.Dto

data class PostDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
) : Dto
