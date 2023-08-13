package com.newaeon.mahaapp

import android.content.Context
import com.google.gson.Gson

class CryptoPrefsUtil {
    companion object {
        private lateinit var INSTANCE: CryptoPrefsUtil
        val instance: CryptoPrefsUtil
            get() {
                if (!this::INSTANCE.isInitialized) {
                    INSTANCE = CryptoPrefsUtil()
                }
                return INSTANCE
            }
    }
    private val prefs = ContextUtil.instance?.getSharedPreferences(
        Constants.PREFERENCES_FILE_NAME,
        Context.MODE_PRIVATE
    );  //w private to prevent share it  ith another app

    fun setValue(key: String, value: Any?) {
        when (value) {
            is Int -> prefs?.edit()?.putInt(key, value)?.apply()
            is String -> prefs?.edit()?.putString(key, value)?.apply()
            is Boolean -> prefs?.edit()?.putBoolean(key, value)?.apply()
            else -> {
                val gson = Gson()
                val json = gson.toJson(value)
                prefs?.edit()?.putString(key, json)?.apply()
            }
        }
    }

    fun getInt(key: String) = prefs?.getInt(key, 0)
    fun getString(key: String) = prefs?.getString(key, "")
    fun getBoolean(key: String) = prefs?.getBoolean(key, false)
    fun getBoolean(key: String, defaultValue: Boolean) = prefs?.getBoolean(key, defaultValue)
    fun <T> getObject(key: String, classOfT: Class<T>): T? {
        val gson = Gson()
        val json = prefs?.getString(key, "")
        return gson.fromJson(json, classOfT)
    }

}