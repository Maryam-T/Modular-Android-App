package com.marand.myapplication.ui.factory.user

import com.marand.domain.user.entity.UserEntity
import com.marand.myapplication.ui.factory.DataFactoryAndroidTest
import com.marand.presentation.main.home.model.UserItemView

object UsersFactoryAndroidTest {

    fun generateListOfUserItemViews(size: Int): MutableList<UserItemView> {
        val listOfMoviesViews = mutableListOf<UserItemView>()
        repeat(size) {
            listOfMoviesViews.add(generateUserItemView())
        }
        return listOfMoviesViews
    }

    fun generateListOfUserEntity(size: Int): MutableList<UserEntity> {
        val listOfMovies = mutableListOf<UserEntity>()
        repeat(size) {
            listOfMovies.add(generateUserEntity())
        }
        return listOfMovies
    }

    private fun generateUserItemView(): UserItemView {
        return UserItemView(
            id = DataFactoryAndroidTest.getRandomInt(),
            name = DataFactoryAndroidTest.getRandomString(),
            username = DataFactoryAndroidTest.getRandomString(),
            email = DataFactoryAndroidTest.getRandomString()
        )
    }

    fun generateUserEntity(): UserEntity {
        return UserEntity(
            id = DataFactoryAndroidTest.getRandomInt(),
            name = DataFactoryAndroidTest.getRandomString(),
            username = DataFactoryAndroidTest.getRandomString(),
            email = DataFactoryAndroidTest.getRandomString()
        )
    }
}