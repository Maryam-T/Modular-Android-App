package com.marand.data.post.datasource

import com.marand.data.RemoteDataSource
import com.marand.data.post.model.PostDataModel
import com.marand.domain.post.request.GetUserPostsRequest

interface PostRemoteDataSource : RemoteDataSource {

    suspend fun fetchUserPosts(request: GetUserPostsRequest): List<PostDataModel>
}