package com.marand.remote.factory.user

import com.marand.data.user.data.UserDataModel
import com.marand.remote.factory.DataFactory
import com.marand.remote.user.dto.UserDto

object UsersFactory {

    fun generateListOfUserDataModel(size: Int): MutableList<UserDataModel> {
        val listOfUserDataModels = mutableListOf<UserDataModel>()
        repeat(size) {
            listOfUserDataModels.add(generateUserDataModel())
        }
        return listOfUserDataModels
    }

    fun generateUserDto(): UserDto {
        return UserDto(
            id = DataFactory.getRandomInt(),
            name = DataFactory.getRandomString(),
            username = DataFactory.getRandomString(),
            email = DataFactory.getRandomString()
        )
    }

    private fun generateUserDataModel(): UserDataModel {
        return UserDataModel(
            id = DataFactory.getRandomInt(),
            name = DataFactory.getRandomString(),
            username = DataFactory.getRandomString(),
            email = DataFactory.getRandomString()
        )
    }

}