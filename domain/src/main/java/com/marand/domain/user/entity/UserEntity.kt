package com.marand.domain.user.entity

import com.marand.domain.Entity

data class UserEntity(
    val id: Int,
    val name: String,
    val username: String,
    val email: String
) : Entity
