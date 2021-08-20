package com.marand.data.post

import com.marand.data.post.datasource.PostCacheDataSource
import com.marand.data.post.datasource.PostRemoteDataSource
import com.marand.data.post.model.PostDataMapper
import com.marand.domain.post.entity.PostEntity
import com.marand.domain.post.repository.PostRepository
import com.marand.domain.post.request.GetUserPostsRequest
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postCacheDataSource: PostCacheDataSource,
    private val postRemoteDataSource: PostRemoteDataSource,
    private val postDataMapper: PostDataMapper
) : PostRepository {

    override suspend fun getUserPosts(request: GetUserPostsRequest): List<PostEntity> {
        val userPosts = postRemoteDataSource.fetchUserPosts(request)
        postCacheDataSource.writeUserPostList(userPosts)
        return List(postCacheDataSource.readUserPostList(request.userId).size) { index ->
            val userDto = userPosts[index]
            postDataMapper.mapToEntity(userDto)
        }
    }
}