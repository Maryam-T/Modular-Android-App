package com.marand.data.user.data

import com.marand.data.DataModel

data class UserDataModel(
    val id: Int,
    val name: String,
    val username: String,
    val email: String
) : DataModel
