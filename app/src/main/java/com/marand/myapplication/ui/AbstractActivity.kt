package com.marand.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.marand.myapplication.App

abstract class AbstractActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        inject()
        (application as App).appComponent
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    abstract fun inject()
}