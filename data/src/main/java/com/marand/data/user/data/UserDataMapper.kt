package com.marand.data.user.data

import com.marand.data.DataMapper
import com.marand.domain.user.entity.UserEntity
import javax.inject.Inject

class UserDataMapper @Inject constructor(

) : DataMapper<UserDataModel, UserEntity> {

    override fun mapToEntity(data: UserDataModel): UserEntity =
        UserEntity(
            data.id,
            data.name,
            data.username,
            data.email
        )
}