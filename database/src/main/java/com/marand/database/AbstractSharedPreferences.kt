package com.marand.database

import android.content.Context
import android.content.SharedPreferences
import com.marand.database.Preferences.Companion.PREFERENCES_NAME

abstract class AbstractSharedPreferences(context: Context) : Preferences {

    protected val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
}
