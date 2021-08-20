package com.marand.presentation.main.post.model

import com.marand.presentation.R
import com.marand.presentation.RecyclerItemView

data class PostItemView (
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
) : RecyclerItemView {
    override val viewId: Int
        get() = R.layout.item_post
}