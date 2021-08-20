package com.marand.remote.post.api

import com.marand.data.post.datasource.PostRemoteDataSource
import com.marand.data.post.model.PostDataModel
import com.marand.domain.post.request.GetUserPostsRequest
import com.marand.remote.AbstractApiService
import com.marand.remote.post.dto.PostDtoMapper
import com.marand.remote.post.request.GetUserPostsRequestDtoMapper
import javax.inject.Inject

class PostApiService @Inject constructor(
    private val postDtoMapper: PostDtoMapper,
    private val getUserPostsRequestDtoMapper: GetUserPostsRequestDtoMapper
) : AbstractApiService<PostEndPoint>(PostEndPoint::class.java), PostRemoteDataSource {

    override suspend fun fetchUserPosts(request: GetUserPostsRequest): List<PostDataModel> {
        //RequestDto is used just for @Body inside request so there is no use of PostRequestDto & GetUserPostsRequestDtoMapper here!
        val response =
            execution { apiService.getUserPosts(request.userId) }.data
        return List(response?.size ?: 0) { index ->
            val postDto = response?.get(index)
            postDtoMapper.mapToData(postDto)
        }
    }
}
