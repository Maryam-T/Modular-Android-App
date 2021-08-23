package com.marand.myapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marand.presentation.RecyclerItemView

abstract class AbstractAdapter<M : RecyclerItemView>(protected val dataList: MutableList<M>) :
    RecyclerView.Adapter<AbstractViewHolder<M>>() {

    var onItemClickListener: ((M) -> Unit)? = null

    protected fun createView(parent: ViewGroup, viewType: Int): View {
        return LayoutInflater.from(parent.context).inflate(viewType, parent, false)
    }

    abstract fun getViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<M>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbstractViewHolder<M> {
        return getViewHolder(parent, viewType)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holderViewHolder: AbstractViewHolder<M>, position: Int) {
        holderViewHolder.onItemClickListener = onItemClickListener
        holderViewHolder.bind(dataList[position])
    }

    override fun getItemViewType(position: Int): Int {
        return dataList[position].viewId
    }
}