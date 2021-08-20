package com.marand.domain.user.repository

import com.marand.domain.user.entity.UserEntity

interface UserRepository {

    suspend fun getUsers(): List<UserEntity>
}