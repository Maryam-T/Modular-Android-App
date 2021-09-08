package com.marand.myapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class AbstractActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    abstract fun inject()
}