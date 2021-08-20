package com.marand.remote.user.api

import com.marand.data.user.data.UserDataModel
import com.marand.data.user.datasource.UserRemoteDataSource
import com.marand.remote.AbstractApiService
import com.marand.remote.user.dto.UserDtoMapper
import javax.inject.Inject

class UserApiService @Inject constructor(
    private val userDtoMapper: UserDtoMapper
) : AbstractApiService<UserEndPoint>(UserEndPoint::class.java), UserRemoteDataSource {

    override suspend fun fetchUsers(): List<UserDataModel> {
        val response = execution { apiService.getUsers()}.data
        return List(response?.size?:0) { index ->
            val userDto = response?.get(index)
            userDtoMapper.mapToData(userDto)
        }
    }
}