package com.marand.myapplication.ui.main

import android.os.Bundle
import com.marand.myapplication.App
import com.marand.myapplication.R
import com.marand.myapplication.ui.AbstractActivity

class MainActivity : AbstractActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
//        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun inject() {
        (application as App).mainComponent()
            .inject(this)
    }
}
