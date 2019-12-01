package com.rightfromleftsw.smarthush.activity

import com.rightfromleftsw.smarthush.permissions.AudioPermissionDelegate
import com.rightfromleftsw.smarthush.permissions.PermissionDelegate
import dagger.Module
import dagger.Provides

@Module(includes = [FragmentModule::class])
object MainActivityModule {

  @Provides
  fun audioPermissionDelegate(mainActivity: MainActivity): PermissionDelegate
      = AudioPermissionDelegate(mainActivity)
}