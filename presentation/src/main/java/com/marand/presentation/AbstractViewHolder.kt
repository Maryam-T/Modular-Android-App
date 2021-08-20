package com.marand.presentation

import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class AbstractViewHolder<M : RecyclerItemView>(containerView: View) :
    RecyclerView.ViewHolder(containerView) {
    var onItemClickListener: ((M) -> Unit)? = null

    abstract fun bind(model: M)

    protected val resources: Resources
        get() = itemView.resources
}
