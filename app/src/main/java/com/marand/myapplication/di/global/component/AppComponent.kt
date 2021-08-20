package com.marand.myapplication.di.global.component

import android.app.Application
import com.marand.myapplication.App
import com.marand.myapplication.di.global.module.AppModule
import com.marand.myapplication.di.layer.database.module.DatabaseModule
import com.marand.myapplication.di.layer.presentation.module.ActivityBuildersModule
import com.marand.myapplication.di.layer.presentation.module.PresentationModule
import com.marand.myapplication.di.layer.remote.module.RemoteModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    ActivityBuildersModule::class,
    AppModule::class,
    RemoteModule::class,
    DatabaseModule::class,
    PresentationModule::class
])
interface AppComponent: AndroidInjector<App>  {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationBind(application: Application): Builder

        fun build(): AppComponent
    }
}
