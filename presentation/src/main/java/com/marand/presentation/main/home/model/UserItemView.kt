package com.marand.presentation.main.home.model

import com.marand.presentation.R
import com.marand.presentation.RecyclerItemView

data class UserItemView(
    val id: Int,
    val name: String,
    val username: String,
    val email: String
) : RecyclerItemView {
    override val viewId: Int
        get() = R.layout.item_user
}
