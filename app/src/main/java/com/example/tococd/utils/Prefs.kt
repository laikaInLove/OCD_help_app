package com.example.tococd.utils

import android.content.Context
import android.content.SharedPreferences

class Prefs (context: Context) {
    private val PREFS_NAME = "com.cursokotlin.sharedpreferences"
    private val SHARED_NAME = "shared_name"
    private val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)
    //Shared for fragments
    private val SHARED_INFORMATION = "shared_information"
    private val SHARED_TYPES = "shared_types"
    private val SHARED_PSYCHOLOGISTS = "shared_psychologists"


    var name: String?
        get() = prefs.getString(SHARED_NAME, "")
        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()

    //Shared for fragments
    var information: String?
        get() = prefs.getString(SHARED_INFORMATION, "")
        set(value) = prefs.edit().putString(SHARED_INFORMATION, value).apply()
    var types: String?
        get() = prefs.getString(SHARED_TYPES, "")
        set(value) = prefs.edit().putString(SHARED_TYPES, value).apply()
    var psychologists: String?
        get() = prefs.getString(SHARED_PSYCHOLOGISTS, "")
        set(value) = prefs.edit().putString(SHARED_PSYCHOLOGISTS, value).apply()

}