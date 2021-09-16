package com.marand.log

interface Logger {

    fun info(tag: String, message: String)

    fun error(tag: String, message: String)

    fun error(tag: String, throwable: Throwable)
}