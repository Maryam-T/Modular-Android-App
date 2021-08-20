package com.marand.myapplication

import android.content.Context
import androidx.multidex.MultiDex
import com.marand.myapplication.di.global.component.DaggerAppComponent
import dagger.android.*

class App : DaggerApplication() {

    private val applicationInjector = DaggerAppComponent.builder()
        .applicationBind(this)
        .build()

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
