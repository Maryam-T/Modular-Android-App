package com.marand.data.user.datasource

import com.marand.data.RemoteDataSource
import com.marand.data.user.data.UserDataModel

interface UserRemoteDataSource : RemoteDataSource {

    suspend fun fetchUsers(): List<UserDataModel>
}