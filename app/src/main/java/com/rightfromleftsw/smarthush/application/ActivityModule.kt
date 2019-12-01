package com.rightfromleftsw.smarthush.application

import com.rightfromleftsw.smarthush.activity.MainActivity
import com.rightfromleftsw.smarthush.activity.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
  @ContributesAndroidInjector(modules = [MainActivityModule::class])
  abstract fun bindMainActivity(): MainActivity
}