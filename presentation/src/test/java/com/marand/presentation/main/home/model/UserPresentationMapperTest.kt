package com.marand.presentation.main.home.model

import com.google.common.truth.Truth.assertThat
import com.marand.domain.user.entity.UserEntity
import com.marand.presentation.factory.user.UsersFactory
import org.junit.Before
import org.junit.Test

class UserPresentationMapperTest {

    private lateinit var userPresentationMapper: UserPresentationMapper

    @Before
    fun setUp() {
        userPresentationMapper = UserPresentationMapper()
    }

    @Test
    fun mapToItemView() {
        //Arrange
        val userEntity = UsersFactory.generateUserEntity()

        //Act
        val userItemView = userPresentationMapper.toPresentation(userEntity)

        //Assert
        assertUserEntityMapDataEqual(userItemView, userEntity)
    }

    private fun assertUserEntityMapDataEqual(userItemView: UserItemView, userEntity: UserEntity) {
        assertThat(userItemView.id).isEqualTo(userEntity.id)
        assertThat(userItemView.name).isEqualTo(userEntity.name)
        assertThat(userItemView.username).isEqualTo(userEntity.username)
        assertThat(userItemView.email).isEqualTo(userEntity.email)
    }
}