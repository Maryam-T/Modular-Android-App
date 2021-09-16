package com.marand.myapplication.di.global.module

import android.app.Application
import android.content.Context
import com.marand.log.Logger
import com.marand.myapplication.LoggerImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @JvmStatic
    @Singleton
    @Provides
    fun provideLogger(loggerImpl: LoggerImpl): Logger = loggerImpl
}
