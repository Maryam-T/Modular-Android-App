package com.marand.remote.user.dto

import com.marand.data.user.data.UserDataModel
import com.google.common.truth.Truth.assertThat
import com.marand.remote.factory.user.UsersFactory
import org.junit.Before
import org.junit.Test

class UserDtoMapperTest {

    private lateinit var userDtoMapper: UserDtoMapper

    @Before
    fun setUp() {
        userDtoMapper = UserDtoMapper()
    }

    @Test
    fun `map to data model`() {
        //Arrange
        val userDto = UsersFactory.generateUserDto()

        //Act
        val userDataModel = userDtoMapper.mapToData(userDto)

        //Assert
        assertUserDtoMapDataEqual(userDto, userDataModel)
    }

    private fun assertUserDtoMapDataEqual(userDto: UserDto, userDataModel: UserDataModel) {
        assertThat(userDto.id).isEqualTo(userDataModel.id)
        assertThat(userDto.name).isEqualTo(userDataModel.name)
        assertThat(userDto.username).isEqualTo(userDataModel.username)
        assertThat(userDto.email).isEqualTo(userDataModel.email)
    }
}