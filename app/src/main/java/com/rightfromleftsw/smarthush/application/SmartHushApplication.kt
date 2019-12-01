package com.rightfromleftsw.smarthush.application

import android.os.StrictMode
import com.rightfromleftsw.smarthush.BuildConfig
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class SmartHushApplication: DaggerApplication() {

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerApplicationComponent.factory().create(this)
  }

  override fun onCreate() {
    super.onCreate()

    if (BuildConfig.DEBUG) {
      Timber.plant(Timber.DebugTree())
      StrictMode.enableDefaults()
    }
  }
}