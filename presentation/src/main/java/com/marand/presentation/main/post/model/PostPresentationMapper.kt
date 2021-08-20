package com.marand.presentation.main.post.model

import com.marand.domain.post.entity.PostEntity
import com.marand.presentation.PresentationMapper
import javax.inject.Inject

class PostPresentationMapper @Inject constructor(

) : PresentationMapper<PostEntity, PostItemView> {

    override fun toPresentation(entity: PostEntity): PostItemView =
        PostItemView(
            entity.id,
            entity.userId,
            entity.title,
            entity.body
        )
}
