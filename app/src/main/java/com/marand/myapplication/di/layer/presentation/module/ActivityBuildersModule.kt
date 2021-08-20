package com.marand.myapplication.di.layer.presentation.module

import com.marand.myapplication.di.layer.presentation.main.MainFragmentsModule
import com.marand.myapplication.di.layer.presentation.scope.main.MainActivityScope
import com.marand.presentation.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @MainActivityScope
    @ContributesAndroidInjector(modules = [MainFragmentsModule::class])
    abstract fun bindMainActivity(): MainActivity
}