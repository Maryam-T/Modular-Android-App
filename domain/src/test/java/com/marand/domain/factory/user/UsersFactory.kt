package com.marand.domain.factory.user

import com.marand.domain.factory.DataFactory
import com.marand.domain.user.entity.UserEntity

object UsersFactory {

    fun generateDummyUserList(size: Int): List<UserEntity> {
        val userList = mutableListOf<UserEntity>()
        repeat(size) {
            userList.add(generateUser())
        }
        return userList
    }

    private fun generateUser(): UserEntity {
        return UserEntity(
            id = DataFactory.getRandomInt(),
            name = "name",
            username = "username",
            email = "email"
        )
    }
}