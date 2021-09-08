package com.marand.myapplication

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.marand.myapplication.di.global.component.AppComponent
import com.marand.myapplication.di.global.component.DaggerAppComponent
import com.marand.myapplication.di.layer.presentation.main.component.MainComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    private var mainComponent: MainComponent? = null

    override fun onCreate() {
        super.onCreate()
        initAppComponent()
    }

    private fun initAppComponent() {
        appComponent = DaggerAppComponent.builder()
            .applicationBind(this)
            .build()
    }

    fun mainComponent(): MainComponent {
        if (mainComponent == null) {
            mainComponent = appComponent.mainComponent().create()
        }
        return mainComponent as MainComponent
    }

    fun releaseMainComponent(){
        mainComponent = null
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}
