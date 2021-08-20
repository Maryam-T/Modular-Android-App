package com.marand.remote.user.api

import com.marand.remote.user.dto.UserDto
import retrofit2.http.GET
import retrofit2.Response

interface UserEndPoint {

    @GET("/users")
    suspend fun getUsers(): Response<List<UserDto>>
}