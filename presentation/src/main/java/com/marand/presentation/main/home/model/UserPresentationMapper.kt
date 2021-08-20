package com.marand.presentation.main.home.model

import com.marand.domain.user.entity.UserEntity
import com.marand.presentation.PresentationMapper
import javax.inject.Inject

class UserPresentationMapper @Inject constructor(

) : PresentationMapper<UserEntity, UserItemView> {
    override fun toPresentation(entity: UserEntity): UserItemView =
        UserItemView(
            entity.id,
            entity.name,
            entity.username,
            entity.email
        )
}