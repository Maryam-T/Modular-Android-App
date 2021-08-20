package com.marand.domain.post.interactor

import com.marand.domain.UseCase
import com.marand.domain.UseCaseResult
import com.marand.domain.post.entity.PostEntity
import com.marand.domain.post.repository.PostRepository
import com.marand.domain.post.request.GetUserPostsRequest
import javax.inject.Inject

class GetUserPostListUseCase @Inject constructor(
    private val postRepository: PostRepository
) : UseCase<GetUserPostsRequest, List<PostEntity>>() {

    override suspend fun run(params: GetUserPostsRequest): UseCaseResult<List<PostEntity>> =
        UseCaseResult(postRepository.getUserPosts(params))
}