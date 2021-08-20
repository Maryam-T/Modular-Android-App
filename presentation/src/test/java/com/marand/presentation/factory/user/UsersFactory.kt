package com.marand.presentation.factory.user

import com.marand.domain.user.entity.UserEntity
import com.marand.presentation.factory.DataFactory
import com.marand.presentation.main.home.model.UserItemView

object UsersFactory {

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
            id = DataFactory.getRandomInt(),
            name = DataFactory.getRandomString(),
            username = DataFactory.getRandomString(),
            email = DataFactory.getRandomString()
        )
    }

    fun generateUserEntity(): UserEntity {
        return UserEntity(
            id = DataFactory.getRandomInt(),
            name = DataFactory.getRandomString(),
            username = DataFactory.getRandomString(),
            email = DataFactory.getRandomString()
        )
    }
}
