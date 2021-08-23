package com.marand.myapplication.di.global.component

import android.app.Application
import com.marand.myapplication.di.global.module.AppModule
import com.marand.myapplication.di.global.module.SubComponentsModule
import com.marand.myapplication.di.layer.database.module.DatabaseModule
import com.marand.myapplication.di.layer.presentation.main.MainComponent
import com.marand.myapplication.di.layer.remote.module.RemoteModule
import com.marand.myapplication.ui.AbstractActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    SubComponentsModule::class,
    RemoteModule::class,
    DatabaseModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationBind(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(abstractActivity: AbstractActivity)

    fun mainComponent(): MainComponent.Factory
}
