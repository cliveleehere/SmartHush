package com.rightfromleftsw.smarthush.main

import com.rightfromleftsw.smarthush.analyzer.detector.Emotion
import io.reactivex.Flowable

class FakeAudio : AudioListener {

  override fun setupAudio() {
  }

  override fun startAudio(): Flowable<MainUiModel> {
    return Flowable.just(MainUiModel(Emotion.HAPPY))
  }

}