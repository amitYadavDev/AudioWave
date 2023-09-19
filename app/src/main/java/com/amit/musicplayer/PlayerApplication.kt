package com.amit.musicplayer

import android.app.Application
import timber.log.Timber

class PlayerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        if (com.amit.musicplayer.BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}