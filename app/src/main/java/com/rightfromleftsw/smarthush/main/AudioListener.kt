package com.rightfromleftsw.smarthush.main

import io.reactivex.Flowable

interface AudioListener {

  fun setupAudio()

  fun startAudio(): Flowable<MainUiModel>
}