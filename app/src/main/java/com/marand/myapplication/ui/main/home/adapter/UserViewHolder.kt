package com.marand.myapplication.ui.main.home.adapter

import android.view.View
import com.marand.myapplication.ui.AbstractViewHolder
import com.marand.presentation.main.home.model.UserItemView
import kotlinx.android.synthetic.main.item_user.view.*

class UserViewHolder(view: View) : AbstractViewHolder<UserItemView>(view) {

    override fun bind(model: UserItemView) {
        itemView.setOnClickListener { onItemClickListener?.invoke(model) }
        itemView.nameTv.text = model.name
        itemView.userNameTv.text = model.username
        itemView.emailTv.text = model.email
    }
}