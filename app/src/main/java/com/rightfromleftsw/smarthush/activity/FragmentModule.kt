package com.rightfromleftsw.smarthush.activity

import com.rightfromleftsw.smarthush.main.MainFragment
import com.rightfromleftsw.smarthush.main.MainFragmentModule
import com.rightfromleftsw.smarthush.di.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

  @FragmentScope
  @ContributesAndroidInjector(modules = [MainFragmentModule::class])
  abstract fun injectCameraFragment(): MainFragment
}