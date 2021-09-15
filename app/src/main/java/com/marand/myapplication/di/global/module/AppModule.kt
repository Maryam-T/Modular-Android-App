package com.marand.myapplication.di.global.module

import android.app.Application
import android.content.Context
import com.example.log.Log
import com.marand.myapplication.LogImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @JvmStatic
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext;

    @Singleton
    @Provides
    fun provideLog(logImpl: LogImpl): Log = logImpl

}
