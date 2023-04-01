package com.hyparz.assessment

import android.app.Application
import android.content.Context

class HyparzApplication : Application() {

    companion object {
        private var appContext: Context? = null

        fun setAppContext(context: Context?) {
            appContext = context
        }

        fun getAppContext(): Context? {
            return appContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        setAppContext(this)
    }
}