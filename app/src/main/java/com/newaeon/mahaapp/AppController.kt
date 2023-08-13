package com.newaeon.mahaapp
import android.app.Application

// Application type execute firstly when run the app and only once executed
// should added in manifest
class AppController:Application() {
    override fun onCreate() {
        super.onCreate()
        ContextUtil.init(baseContext)
    }
}