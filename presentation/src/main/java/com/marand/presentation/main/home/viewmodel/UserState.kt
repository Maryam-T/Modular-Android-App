package com.marand.presentation.main.home.viewmodel

import com.marand.presentation.main.home.model.UserItemView

sealed class UserState {
    object Init : UserState()
    object Loading : UserState()
    data class Error(var message: String?) : UserState()
    data class Success(var users: List<UserItemView>) : UserState()
}