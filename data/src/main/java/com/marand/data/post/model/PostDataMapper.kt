package com.marand.data.post.model

import com.marand.data.DataMapper
import com.marand.domain.post.entity.PostEntity
import javax.inject.Inject

class PostDataMapper @Inject constructor(

) : DataMapper<PostDataModel, PostEntity> {

    override fun mapToEntity(data: PostDataModel): PostEntity =
        PostEntity(
            data.id,
            data.userId,
            data.title,
            data.body
        )
}
