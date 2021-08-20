package com.marand.remote.post.api

import com.marand.remote.post.dto.PostDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostEndPoint {

    @GET("/posts")
    suspend fun getUserPosts(@Query("userId") userId: Int): Response<List<PostDto>>
}
