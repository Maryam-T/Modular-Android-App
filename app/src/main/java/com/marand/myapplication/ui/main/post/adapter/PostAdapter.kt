package com.marand.myapplication.ui.main.post.adapter

import android.view.ViewGroup
import com.marand.presentation.main.post.model.PostItemView

class PostAdapter(list: List<PostItemView>) :
    com.marand.myapplication.ui.AbstractAdapter<PostItemView>(list.toMutableList()) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): com.marand.myapplication.ui.AbstractViewHolder<PostItemView> {
        return PostViewHolder(
            createView(parent, viewType)
        )
    }
}
