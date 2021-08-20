package com.marand.remote.user.dto

import com.marand.data.user.data.UserDataModel
import com.marand.remote.DtoMapper
import javax.inject.Inject

class UserDtoMapper @Inject constructor(

) : DtoMapper<UserDto, UserDataModel> {

    override fun mapToData(dto: UserDto?): UserDataModel =
        UserDataModel(
            dto!!.id,
            dto.name,
            dto.username,
            dto.email
        )
}