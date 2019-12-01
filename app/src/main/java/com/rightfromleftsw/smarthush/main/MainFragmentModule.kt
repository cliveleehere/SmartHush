package com.rightfromleftsw.smarthush.main

import dagger.Module
import dagger.Provides

@Module
object MainFragmentModule {

  @Provides
  fun cameraX(): AudioInterface = FakeAudio()
}