package com.marand.domain.post.entity

import com.marand.domain.Entity

data class PostEntity(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
) : Entity
