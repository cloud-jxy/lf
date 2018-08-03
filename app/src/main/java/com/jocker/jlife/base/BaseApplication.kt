package com.jocker.jlife.base

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.jocker.jlife.db.JLifeDatabase

class BaseApplication : MultiDexApplication() {

    companion object {
        private var baseApplication: Application? = null
        fun getInstance(): Application {
            return baseApplication!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        baseApplication = this
    }
}