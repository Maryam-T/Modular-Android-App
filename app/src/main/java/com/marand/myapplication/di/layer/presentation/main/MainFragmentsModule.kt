package com.marand.myapplication.di.layer.presentation.main

import com.marand.myapplication.di.layer.presentation.main.home.HomeModule
import com.marand.myapplication.di.layer.presentation.main.post.PostModule
import com.marand.myapplication.di.layer.presentation.scope.main.MainScope
import com.marand.presentation.main.home.view.HomeFragment
import com.marand.presentation.main.post.view.PostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentsModule {

    @MainScope
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindHomeFragment(): HomeFragment

    @MainScope
    @ContributesAndroidInjector(modules = [PostModule::class])
    abstract fun bindPostFragment(): PostFragment
}