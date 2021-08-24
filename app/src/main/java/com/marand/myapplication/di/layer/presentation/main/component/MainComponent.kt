package com.marand.myapplication.di.layer.presentation.main.component

import com.marand.myapplication.di.layer.presentation.main.module.MainModule
import com.marand.myapplication.di.layer.presentation.main.module.MainViewModelModule
import com.marand.myapplication.di.layer.presentation.main.scope.MainScope
import com.marand.myapplication.ui.main.MainActivity
import com.marand.myapplication.ui.main.home.view.HomeFragment
import com.marand.myapplication.ui.main.post.view.PostFragment
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

    fun inject(homeFragment: HomeFragment)

    fun inject(postFragment: PostFragment)
}