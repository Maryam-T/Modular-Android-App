package com.marand.myapplication.util

import java.io.IOException

class NoConnectivityException : IOException() {

    override val message: String
        get() = "No Connection Exception!"
}