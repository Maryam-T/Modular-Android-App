package com.marand.myapplication.di.layer.presentation.main.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marand.myapplication.di.layer.presentation.main.MainScope
import javax.inject.Inject
import javax.inject.Provider

@MainScope
class MainViewModelFactory @Inject constructor(
    private val viewModelProviders: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val provider = viewModelProviders[modelClass]
            ?: viewModelProviders.entries.first {modelClass.isAssignableFrom(it.key)}.value

        return provider.get() as T
    }
}
