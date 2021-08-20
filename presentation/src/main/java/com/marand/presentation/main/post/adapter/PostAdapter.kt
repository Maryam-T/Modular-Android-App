package com.marand.presentation.main.post.adapter

import android.view.ViewGroup
import com.marand.presentation.AbstractAdapter
import com.marand.presentation.AbstractViewHolder
import com.marand.presentation.main.post.model.PostItemView

class PostAdapter(list: List<PostItemView>) :
    AbstractAdapter<PostItemView>(list.toMutableList()) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<PostItemView> {
        return PostViewHolder(
            createView(parent, viewType)
        )
    }
}
