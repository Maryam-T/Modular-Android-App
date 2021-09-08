package com.marand.myapplication.ui.main.home.adapter

import android.view.ViewGroup
import com.marand.presentation.main.home.model.UserItemView

class UserAdapter(list: List<UserItemView>) :
    com.marand.myapplication.ui.AbstractAdapter<UserItemView>(list.toMutableList()) {

    override fun getViewHolder(parent: ViewGroup, viewType: Int): com.marand.myapplication.ui.AbstractViewHolder<UserItemView> {
        return UserViewHolder(
            createView(parent, viewType)
        )
    }
}