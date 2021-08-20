package com.marand.remote.post.dto

import com.marand.data.post.model.PostDataModel
import com.marand.remote.DtoMapper
import javax.inject.Inject

class PostDtoMapper @Inject constructor(

) : DtoMapper<PostDto, PostDataModel> {

    override fun mapToData(dto: PostDto?): PostDataModel =
        PostDataModel(
            dto!!.id,
            dto.userId,
            dto.title,
            dto.body
        )
}