package com.marand.presentation.main.home.adapter

import android.view.ViewGroup
import com.marand.presentation.AbstractAdapter
import com.marand.presentation.AbstractViewHolder
import com.marand.presentation.main.home.model.UserItemView

class UserAdapter(list: List<UserItemView>) :
    AbstractAdapter<UserItemView>(list.toMutableList()) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<UserItemView> {
        return UserViewHolder(
            createView(parent, viewType)
        )
    }
}