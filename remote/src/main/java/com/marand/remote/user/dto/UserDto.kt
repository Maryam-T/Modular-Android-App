package com.marand.remote.user.dto

import com.google.gson.annotations.SerializedName
import com.marand.remote.Dto

data class UserDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String
) : Dto
