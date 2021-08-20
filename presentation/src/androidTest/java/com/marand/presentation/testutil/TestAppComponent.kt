package com.marand.presentation.testutil

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestAppModule::class,
    AndroidInjectionModule::class
])
interface TestAppComponent: AndroidInjector<TestApp> {

    /*@Component.Builder
    abstract class Builder : AndroidInjector.Builder<TestApp>() {
        abstract fun appModule(appModule: TestAppModule): Builder
    }*/

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationBind(application: TestApp): Builder

        fun build(): TestAppComponent
    }
}