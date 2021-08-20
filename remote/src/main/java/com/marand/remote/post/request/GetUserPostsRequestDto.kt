package com.marand.remote.post.request

import com.marand.remote.request.RequestDto

data class GetUserPostsRequestDto (
    val userId: Int
) : RequestDto