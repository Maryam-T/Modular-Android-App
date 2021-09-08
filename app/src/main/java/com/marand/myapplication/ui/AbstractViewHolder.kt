package com.marand.myapplication.ui

import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.marand.presentation.RecyclerItemView

abstract class AbstractViewHolder<M : RecyclerItemView>(containerView: View) :
    RecyclerView.ViewHolder(containerView) {
    var onItemClickListener: ((M) -> Unit)? = null

    abstract fun bind(model: M)

    protected val resources: Resources
        get() = itemView.resources
}
