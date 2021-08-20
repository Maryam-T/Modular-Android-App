package com.marand.domain.post.repository

import com.marand.domain.post.entity.PostEntity
import com.marand.domain.post.request.GetUserPostsRequest

interface PostRepository {

    suspend fun getUserPosts(request: GetUserPostsRequest): List<PostEntity>
}