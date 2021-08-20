package com.marand.database.sample

import android.content.Context
import com.marand.database.AbstractSharedPreferences
import javax.inject.Inject

class SampleSharedPreferences @Inject constructor(
    context: Context
) : AbstractSharedPreferences(context), SamplePreferences {
    
    override var param: String
        get() = sharedPreferences.getString(PARAM_KEY, null).toString()
        set(value) = sharedPreferences.edit().putString(PARAM_KEY, value).apply()

    companion object {
        private const val PARAM_KEY = "param_key"
    }
}
