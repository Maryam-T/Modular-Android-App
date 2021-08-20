package com.marand.data.user

import com.marand.data.user.data.UserDataMapper
import com.marand.data.user.datasource.UserRemoteDataSource
import com.marand.domain.user.entity.UserEntity
import com.marand.domain.user.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userDataMapper: UserDataMapper
) : UserRepository {

    override suspend fun getUsers(): List<UserEntity> {
        val users = userRemoteDataSource.fetchUsers()
        return List(users.size) { index ->
            val userDto = users[index]
            userDataMapper.mapToEntity(userDto)
        }
    }
}