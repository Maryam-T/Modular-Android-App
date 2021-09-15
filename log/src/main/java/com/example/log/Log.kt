package com.example.log

interface Log {
    fun info(message: String)
    fun info(tag: String, message: String)
}