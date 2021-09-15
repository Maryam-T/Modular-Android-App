package com.marand.myapplication

import com.example.log.Log
import okio.utf8Size
import javax.inject.Inject


class LogImpl @Inject constructor(): Log {
    override fun info(message: String) {
        android.util.Log.d("Logger", message)
    }
    override fun info(tag: String, message: String) {
        android.util.Log.d(tag.substring(0, if(tag.length < 23) tag.length else 23), message)
    }
}