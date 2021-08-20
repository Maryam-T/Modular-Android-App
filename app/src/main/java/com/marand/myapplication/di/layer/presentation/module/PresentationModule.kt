package com.marand.myapplication.di.layer.presentation.module

import androidx.lifecycle.ViewModelProvider
import com.marand.myapplication.di.layer.presentation.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class PresentationModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
