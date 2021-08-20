package com.marand.domain.post.request

import com.marand.domain.Request

data class GetUserPostsRequest(
    val userId: Int
) : Request
