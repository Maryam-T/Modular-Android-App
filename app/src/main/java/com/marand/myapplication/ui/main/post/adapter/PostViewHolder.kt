package com.marand.myapplication.ui.main.post.adapter

import android.view.View
import com.marand.myapplication.ui.AbstractViewHolder
import com.marand.presentation.main.post.model.PostItemView
import kotlinx.android.synthetic.main.item_post.view.*

class PostViewHolder(view: View) : AbstractViewHolder<PostItemView>(view) {

    override fun bind(model: PostItemView) {
        itemView.titleTv.text = model.title
        itemView.bodyTv.text = model.body
    }
}
