package com.rightfromleftsw.smarthush.application

import android.content.Context
import com.rightfromleftsw.smarthush.di.AppScope
import dagger.Module
import dagger.Provides

@Module
object ApplicationModule {
  @Provides
  @AppScope
  @JvmStatic
  fun appContext(app: SmartHushApplication): Context = app.applicationContext
}