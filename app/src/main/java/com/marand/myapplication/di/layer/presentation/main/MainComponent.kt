package com.marand.myapplication.di.layer.presentation.main

import com.marand.myapplication.ui.main.MainActivity
import dagger.Subcomponent

@MainScope
@Subcomponent(modules = [
    MainModule::class,
    MainViewModelModule::class
])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {

        fun create(): MainComponent
    }

    fun inject(mainActivity: MainActivity)
}