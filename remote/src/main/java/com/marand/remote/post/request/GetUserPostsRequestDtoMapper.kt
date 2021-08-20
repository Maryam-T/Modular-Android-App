package com.marand.remote.post.request

import com.marand.domain.post.request.GetUserPostsRequest
import com.marand.remote.request.RequestDtoMapper
import javax.inject.Inject

class GetUserPostsRequestDtoMapper @Inject constructor(

) : RequestDtoMapper<GetUserPostsRequest, GetUserPostsRequestDto> {

    override fun mapToDto(request: GetUserPostsRequest): GetUserPostsRequestDto =
        GetUserPostsRequestDto(
            request.userId
        )
}
