package com.marand.myapplication.ui.main

import android.os.Bundle
import android.util.Log
import com.marand.myapplication.App
import com.marand.myapplication.R
import com.marand.myapplication.ui.AbstractActivity

class MainActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread.setDefaultUncaughtExceptionHandler { t, e ->
            e.printStackTrace()
            Log.d("MainActivity", t.toString())
        }
    }

    override fun inject() {
        (application as App).mainComponent()
            .inject(this)
    }
}
