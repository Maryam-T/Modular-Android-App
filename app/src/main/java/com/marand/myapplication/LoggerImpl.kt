package com.marand.myapplication

import android.util.Log
import com.marand.log.Logger
import javax.inject.Inject

class LoggerImpl @Inject constructor(): Logger {
    override fun info(tag: String, message: String) {
        Log.d(tag, message)
    }

    override fun error(tag: String, message: String) {
        Log.e(tag, message)
    }

    override fun error(tag: String, throwable: Throwable) {
        Log.e(tag, throwable.toString())
    }
}