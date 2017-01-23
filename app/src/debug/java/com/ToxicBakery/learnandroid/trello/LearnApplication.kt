package com.ToxicBakery.learnandroid.trello

import android.app.Application
import timber.log.Timber

/**
 * Created by ianthomas on 1/23/17.
 */
class LearnApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }

}