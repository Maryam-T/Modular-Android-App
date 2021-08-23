package com.marand.myapplication.di.layer.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.marand.myapplication.di.layer.presentation.main.factory.MainViewModelFactory
import com.marand.myapplication.di.layer.presentation.main.key.MainViewModelKey
import com.marand.presentation.main.home.viewmodel.UserViewModel
import com.marand.presentation.main.post.viewmodel.PostViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @MainScope
    @Binds
    abstract fun bindMainViewModelFactory(factory: MainViewModelFactory): ViewModelProvider.Factory

    @MainScope
    @Binds
    @IntoMap
    @MainViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(viewModel: UserViewModel): ViewModel

    @MainScope
    @Binds
    @IntoMap
    @MainViewModelKey(PostViewModel::class)
    abstract fun bindPostViewModel(viewModel: PostViewModel): ViewModel
}